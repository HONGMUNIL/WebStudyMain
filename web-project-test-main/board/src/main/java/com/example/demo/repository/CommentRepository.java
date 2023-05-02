package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer>{
    public List<CommentEntity> findByBoardNumberOrderByWriterDateDesc(int boardNumber);

    public List<CommentEntity> findByWriterEmail(String email);

    public List<CommentEntity> deleteByBoardNumber(int boardNumber);
}
