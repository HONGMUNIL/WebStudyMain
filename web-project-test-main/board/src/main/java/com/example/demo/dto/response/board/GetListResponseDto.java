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
public class GetListResponseDto {
    private int boardNumber;
    private String boardImgUrl;

    //메인에 게시물 첫번째 사진만 가지고 올 것.
    public GetListResponseDto(BoardEntity boardEntity) {
        this.boardNumber = boardEntity.getBoardNumber();
        this.boardImgUrl = boardEntity.getBoardImgUrl1();
    }

    public static List<GetListResponseDto> copyList(List<BoardEntity> boardEntityList) {
        List<GetListResponseDto> list = new ArrayList<>();

        for (BoardEntity boardEntity: boardEntityList) {
            GetListResponseDto dto = new GetListResponseDto(boardEntity);
            list.add(dto);
        }

        return list;
    }

}
