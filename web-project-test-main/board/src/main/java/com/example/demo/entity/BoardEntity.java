package com.example.demo.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.dto.request.board.PatchBoardDto;
import com.example.demo.dto.request.board.PostBoardDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Board")
@Table(name="Board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AOTO_INCREMENT 의 기능
    private int boardNumber;
    private String boardContent;
    private String boardImgUrl1;
    private String boardImgUrl2;
    private String boardImgUrl3;
    private String tag;
    private String boardWriteTime;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileUrl;
    private int commentCount;
    private int likeCount;
    private int viewCount;

    public BoardEntity(UserEntity entity, PostBoardDto dto) {

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = simpleDateFormat.format(date);

        this.boardContent = dto.getBoardContent();
        this.boardImgUrl1 = dto.getBoardImgUrl1();
        this.boardImgUrl2 = dto.getBoardImgUrl2();
        this.boardImgUrl3 = dto.getBoardImgUrl3();
        this.tag = dto.getTag();
        this.boardWriteTime = now;
        this.writerEmail = entity.getEmail();
        this.writerNickname = entity.getNickname();
        this.writerProfileUrl = entity.getProfile();
        this.commentCount = 0;
        this.likeCount = 0;
        this.viewCount = 0;
    }

    public void patch(PatchBoardDto dto) {
        this.boardContent = dto.getBoardContent();
        this.boardImgUrl1 = dto.getBoardImgUrl1();
        this.boardImgUrl2 = dto.getBoardImgUrl2();
        this.boardImgUrl3 = dto.getBoardImgUrl3();
        this.tag = dto.getTag();
    }

    public void patchProfile(String email) {
        this.writerProfileUrl = email;
    }
}
