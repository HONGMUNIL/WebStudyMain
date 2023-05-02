package com.example.demo.dto.request.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignInDto {
    @NotBlank
    @Email
    @Length(max=40)
    private String email;

    @NotBlank
    @Length(min = 8, max = 20)
    private String password;
}
