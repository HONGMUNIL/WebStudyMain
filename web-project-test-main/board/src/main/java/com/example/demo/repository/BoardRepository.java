package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
    // 게시물 작성 시간 순으로 리스트 가져올거
    public List<BoardEntity> findByOrderByBoardWriteTimeDesc();

    // 자신이 작성한 게시물 시간순, 리스트 형태로 가져옴
    public List<BoardEntity> findByWriterEmailOrderByBoardWriteTimeDesc(String writerEmail);

    // 게시물 고유번호 대조 후 수정, 삭제때 씀
    public BoardEntity findByBoardNumber(int boardNumber);

    public List<BoardEntity> findByWriterEmail(String writerEmail);

    public List<BoardEntity> findByTag(String tag);

    public List<BoardEntity> findTop3ByBoardWriteTimeGreaterThanOrderByLikeCountDesc(String aWeekAgo);
}
