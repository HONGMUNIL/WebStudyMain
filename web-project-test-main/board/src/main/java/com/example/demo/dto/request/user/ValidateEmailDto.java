package com.example.demo.dto.request.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ValidateEmailDto {   
    @NotBlank
    @Email
    private String email;
}