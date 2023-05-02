package com.example.demo.dto.response.board;

import java.util.List;

import com.example.demo.entity.BoardEntity;
import com.example.demo.entity.CommentEntity;
import com.example.demo.entity.LikyEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchBoardResponseDto {
    private BoardEntity boardEntity;
    private List<CommentEntity> commentEntity;
    private List<LikyEntity> likyEntity;

}
