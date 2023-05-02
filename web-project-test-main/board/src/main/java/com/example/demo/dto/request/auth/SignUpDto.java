package com.example.demo.dto.request.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {
    @NotBlank
    @Email
    @Length(max=45)
    private String email;
    @NotBlank
    @Length(min=8, max=20)
    private String password;
    @NotBlank
    @Length(min=2, max = 10)
    private String nickname;
    @NotBlank
    private String weight;
    @NotBlank
    private String height;
    @NotBlank
    private String gender;

}
