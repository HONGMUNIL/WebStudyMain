package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LikyEntity;
import com.example.demo.entity.primaryKey.LikyPK;

@Repository
public interface LikyRepository extends JpaRepository<LikyEntity, LikyPK> {
    public List<LikyEntity> findByBoardNumber(int boardNumber);

    public List<LikyEntity> findByUserEmail(String userEmail);

    public LikyEntity deleteByBoardNumber(int boardNumber);
}
