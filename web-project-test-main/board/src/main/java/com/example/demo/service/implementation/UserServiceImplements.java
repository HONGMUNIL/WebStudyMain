package com.example.demo.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.user.PatchProfileDto;
import com.example.demo.dto.request.user.ValidateEmailDto;
import com.example.demo.dto.request.user.ValidateNicknameDto;
import com.example.demo.dto.response.ResponseDto;
import com.example.demo.dto.response.user.GetUserResponseDto;
import com.example.demo.dto.response.user.PatchProfileResponseDto;
import com.example.demo.dto.response.user.ValidateEmailResponseDto;
import com.example.demo.dto.response.user.ValidateNicknameResponseDto;
import com.example.demo.entity.BoardEntity;
import com.example.demo.entity.CommentEntity;
import com.example.demo.entity.LikyEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.LikyRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.common.constant.ResponseMessage;

@Service //서비스로 지정
public class UserServiceImplements implements UserService {
    
    @Autowired 
    private UserRepository userRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private CommentRepository commentRepository;
    
    @Autowired
    private LikyRepository likyRepository;

    public ResponseDto<GetUserResponseDto> getUser(String email) {

        GetUserResponseDto data = null;

        // 찾는 값이 있으면 성공 메세지를 반환, 데이터 베이스가 오류거나, 찾는 값이 없으면 에러메세지 반환.
        try {
            UserEntity userEntity = userRepository.findByEmail(email);
            if(userEntity == null)
            return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);
            data = new GetUserResponseDto(userEntity);
        }catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 이메일 중복체크
    public ResponseDto<ValidateEmailResponseDto> validateEmail(ValidateEmailDto dto) {
        ValidateEmailResponseDto data = null;

        String email = dto.getEmail();

        try {
            boolean hasEmail = userRepository.existsByEmail(email);
            data = new ValidateEmailResponseDto(!hasEmail);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 닉네임 중복 체크
    public ResponseDto<ValidateNicknameResponseDto> validateNickname(ValidateNicknameDto dto) {
        ValidateNicknameResponseDto data = null;

        String nickname = dto.getNickname();

        try {
            boolean hasNickname = userRepository.existsByNickname(nickname);
            data = new ValidateNicknameResponseDto(!hasNickname);
        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 프로필 수정
    public ResponseDto<PatchProfileResponseDto> patchProfile(String email, PatchProfileDto patchProfileDto) {
        PatchProfileResponseDto data = null;

        try {
            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);

            String userProfile = patchProfileDto.getProfile();
            userEntity.patchProfile(userProfile);
            userRepository.save(userEntity);

            List<BoardEntity> boardEntityList = boardRepository.findByWriterEmail(email);
            int boardEntitySize = boardEntityList.size();
            BoardEntity boardEntity = null;
            for (int i = 0; i < boardEntitySize; i++) {
                boardEntity = boardEntityList.get(i);
                boardEntity.patchProfile(userProfile);
                boardRepository.save(boardEntity);
            }

            List<CommentEntity> commentEntityList = commentRepository.findByWriterEmail(email);
            int commentEntitySize = commentEntityList.size();
            CommentEntity commentEntity = null;
            for (int i = 0; i < commentEntitySize; i++) {
                commentEntity = commentEntityList.get(i);
                commentEntity.patchProfile(userProfile);
                commentRepository.save(commentEntity);
            }

            List<LikyEntity> likyEntityList = likyRepository.findByUserEmail(email);
            int likyEntitySize = likyEntityList.size();
            LikyEntity likyEntity = null;
            for (int i = 0; i < likyEntitySize; i++) {
                likyEntity = likyEntityList.get(i);
                likyEntity.patchProfile(userProfile);
                likyRepository.save(likyEntity);
            }

            data = new PatchProfileResponseDto(true);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

}

