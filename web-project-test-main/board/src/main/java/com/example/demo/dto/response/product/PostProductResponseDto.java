package com.example.demo.dto.response.product;

import com.example.demo.entity.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostProductResponseDto {
    private int productNumber;
    private String productName;
    private int productPrice;
    private String productUrl;
    private String productImgUrl;

    public PostProductResponseDto(ProductEntity productEntity) {
        this.productNumber = productEntity.getProductNumber();
        this.productName = productEntity.getProductName();
        this.productPrice = productEntity.getProductPrice();
        this.productUrl = productEntity.getProductUrl();
        this.productImgUrl = productEntity.getProductImgUrl();
    }
}
