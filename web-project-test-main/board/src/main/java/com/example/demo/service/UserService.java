package com.example.demo.service;

import com.example.demo.dto.request.user.PatchProfileDto;
import com.example.demo.dto.request.user.ValidateEmailDto;
import com.example.demo.dto.request.user.ValidateNicknameDto;
import com.example.demo.dto.response.ResponseDto;
import com.example.demo.dto.response.user.GetUserResponseDto;
import com.example.demo.dto.response.user.PatchProfileResponseDto;
import com.example.demo.dto.response.user.ValidateEmailResponseDto;
import com.example.demo.dto.response.user.ValidateNicknameResponseDto;

public interface UserService {
    public ResponseDto<PatchProfileResponseDto> patchProfile(String email, PatchProfileDto dto);

    public ResponseDto<GetUserResponseDto> getUser(String email);

    public ResponseDto<ValidateEmailResponseDto> validateEmail(ValidateEmailDto dto);

    public ResponseDto<ValidateNicknameResponseDto> validateNickname(ValidateNicknameDto dto);
        
}
