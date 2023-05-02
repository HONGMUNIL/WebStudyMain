package com.example.demo.dto.request.product;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostProductDto {
    @NotBlank
    private String productName;
    private int productPrice;
    private String productUrl;
    private String productImgUrl;
}
