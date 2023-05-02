package com.example.demo.dto.response.product;

import com.example.demo.entity.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchProductResponseDto {
    
    private ProductEntity product;
}
