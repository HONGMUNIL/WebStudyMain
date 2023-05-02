package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.common.constant.ApiPattern;
import com.example.demo.service.AuthService;
import com.example.demo.dto.request.auth.SignInDto;
import com.example.demo.dto.request.auth.SignUpDto;
import com.example.demo.dto.response.ResponseDto;
import com.example.demo.dto.response.auth.SignInResponseDto;
import com.example.demo.dto.response.auth.SignUpResponseDto;

@RestController
@RequestMapping(ApiPattern.AUTH)
public class AuthController { //인증 모듈 구현

    @Autowired 
    private AuthService authService;

    private final String SIGN_UP = "/sign-up";
    private final String SIGN_IN = "/sign-in";

    @PostMapping(SIGN_IN)
    public ResponseDto<SignInResponseDto> signIn(@RequestBody SignInDto requestBody) {
        ResponseDto<SignInResponseDto> response = authService.signIn(requestBody);
        return response;
    }

    @PostMapping(SIGN_UP)
    public ResponseDto<SignUpResponseDto> signUp(@Valid @RequestBody SignUpDto requestBody) {
        ResponseDto<SignUpResponseDto> response = authService.signUp(requestBody);
        return response;
    }
}
