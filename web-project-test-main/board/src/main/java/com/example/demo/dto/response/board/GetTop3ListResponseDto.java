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
public class GetTop3ListResponseDto {
    private int boardNumber;
    private String boardTitle;
    private String boardContent;
    private String boardImgUrl;
    private String boardWriteDatetime;
    private int viewCount;
    private String writerNickname;
    private String writerProfileUrl;
    private int commentCount;
    private int likeCount;

    public GetTop3ListResponseDto(BoardEntity boardEntity) {
        this.boardNumber = boardEntity.getBoardNumber();
        this.boardContent = boardEntity.getBoardContent();
        this.boardImgUrl = boardEntity.getBoardImgUrl1();
        this.boardImgUrl = boardEntity.getBoardImgUrl2();
        this.boardImgUrl = boardEntity.getBoardImgUrl3();
        this.boardWriteDatetime = boardEntity.getBoardWriteTime();
        this.viewCount = boardEntity.getViewCount();
        this.writerNickname = boardEntity.getWriterNickname();
        this.writerProfileUrl = boardEntity.getWriterProfileUrl();
        this.commentCount = boardEntity.getCommentCount();
        this.likeCount = boardEntity.getLikeCount();
    }

    public static List<GetTop3ListResponseDto> copyList(List<BoardEntity> boardEntityList) {

        List<GetTop3ListResponseDto> list = new ArrayList<>();

        for (BoardEntity boardEntity: boardEntityList) {
            GetTop3ListResponseDto dto = new GetTop3ListResponseDto(boardEntity);
            list.add(dto);
        }

        return list;

    }
}
