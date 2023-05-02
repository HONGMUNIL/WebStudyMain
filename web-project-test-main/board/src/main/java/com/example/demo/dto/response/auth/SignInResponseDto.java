package com.example.demo.dto.response.auth;

import com.example.demo.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInResponseDto {
    private String email;
    private String nickname;
    private String height;
    private String weight;
    private String gender;
    private String profile;
    // 토큰을 지정
    private String token;
    // 토큰 만료 기간
    private int expiredTime;

    public SignInResponseDto(UserEntity userEntity, String token) {
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.height = userEntity.getHeight();
        this.weight = userEntity.getWeight();
        this.gender = userEntity.getGender();
        this.profile = userEntity.getProfile();
        this.token = token;
        this.expiredTime = 3600000;
    }
}
