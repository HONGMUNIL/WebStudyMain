package com.example.demo.entity.primaryKey;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Data;

@Data
public class LikyPK implements Serializable {
    
    @Column(name = "board_number")
    private int boardNumber;

    @Column(name = "user_email")
    private String userEmail;
    
}
