package com.example.demo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.common.constant.ResponseMessage;
import com.example.demo.dto.request.auth.SignInDto;
import com.example.demo.dto.request.auth.SignUpDto;
import com.example.demo.dto.response.ResponseDto;
import com.example.demo.dto.response.auth.SignInResponseDto;
import com.example.demo.dto.response.auth.SignUpResponseDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.provider.TokenProvider;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;

@Service
public class AuthServiceImplements implements AuthService {
    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    //로그인 구현
    public ResponseDto<SignInResponseDto> signIn(SignInDto dto) {

        SignInResponseDto data = null;

        String email = dto.getEmail();
        String password = dto.getPassword();

        UserEntity userEntity = null;

        try{
            userEntity = userRepository.findByEmail(email);
            if (userEntity == null)
                return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);

            boolean isEqualPassword = passwordEncoder.matches(password, userEntity.getPassword());    
        }catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        try {
            String token = tokenProvider.create(email);
            data = new SignInResponseDto(userEntity, token);
        }catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 회원가입 구현
    public ResponseDto<SignUpResponseDto> signUp(SignUpDto dto) {
        
        SignUpResponseDto data = null;

        String email = dto.getEmail();
        String password = dto.getPassword();
        String nickname = dto.getNickname();
        

        try {
            boolean hasEmail = userRepository.existsByEmail(email);
            if (hasEmail) return ResponseDto.setFailed(ResponseMessage.EXIST_EMAIL);
            
            boolean hasNickname = userRepository.existsByNickname(nickname);
            if (hasNickname) return ResponseDto.setFailed(ResponseMessage.EXIST_NICKNAME);

            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

            data = new SignUpResponseDto(true);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }


}


