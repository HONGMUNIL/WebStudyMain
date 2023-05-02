package com.example.demo.dto.response.user;

import com.example.demo.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponseDto {
    //가지고 올 유저 정보들을 저장하는 장소를 선언
    private String email;

    private String nickname;

    private String height;

    private String weight;

    private String gender;

    private String profile;

    // 유저 엔티티에서 가져올 값을 선언한 값에 넣어줌.
    public GetUserResponseDto(UserEntity userEntity) { 
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.height = userEntity.getHeight();
        this.weight = userEntity.getWeight();
        this.gender = userEntity.getGender();
        this.profile = userEntity.getProfile();
    }
}
