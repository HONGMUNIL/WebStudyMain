package com.example.demo.service;

import com.example.demo.dto.request.auth.SignInDto;
import com.example.demo.dto.request.auth.SignUpDto;
import com.example.demo.dto.response.ResponseDto;
import com.example.demo.dto.response.auth.SignInResponseDto;
import com.example.demo.dto.response.auth.SignUpResponseDto;

public interface AuthService {
    public ResponseDto<SignInResponseDto> signIn(SignInDto dto);
    public ResponseDto<SignUpResponseDto> signUp(SignUpDto dto);
    
}
