package com.example.demo.service;

import com.example.demo.dto.request.product.PatchProductDto;
import com.example.demo.dto.request.product.PostProductDto;
import com.example.demo.dto.response.ResponseDto;
import com.example.demo.dto.response.product.PatchProductResponseDto;
import com.example.demo.dto.response.product.PostProductResponseDto;

public interface ProductService {
    public ResponseDto<PostProductResponseDto> postProduct(String email, PostProductDto dto);

    public ResponseDto<PatchProductResponseDto> patchProductResponseDto(String email ,PatchProductDto dto);
}
