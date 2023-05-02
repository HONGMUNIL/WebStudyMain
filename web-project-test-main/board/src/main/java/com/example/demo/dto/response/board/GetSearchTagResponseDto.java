package com.example.demo.dto.response.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetSearchTagResponseDto {
    private int boardNumber;
    private String boardImgUrl1;
}

