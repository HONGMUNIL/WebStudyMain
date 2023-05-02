package com.example.demo.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.BoardEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostMyListResponseDto {
    private int boardNumber;
    private String boardImgUrl;

    public PostMyListResponseDto(BoardEntity boardEntity) {
        this.boardNumber = boardEntity.getBoardNumber();
        this.boardImgUrl = boardEntity.getBoardImgUrl1();
    }

    public static List<PostMyListResponseDto> copyList(List<BoardEntity> boardEntityList) {

        List<PostMyListResponseDto> list = new ArrayList<>();

        for (BoardEntity boardEntity: boardEntityList) {
            PostMyListResponseDto dto = new PostMyListResponseDto(boardEntity);
            list.add(dto);
        }
        return list;
    }
}
