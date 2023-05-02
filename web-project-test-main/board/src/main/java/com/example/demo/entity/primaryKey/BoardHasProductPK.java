package com.example.demo.entity.primaryKey;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Data;

@Data
public class BoardHasProductPK implements Serializable {

    @Column(name = "product_number")
    private int productNumber;

    @Column(name = "board_number")
    private int boardNumber;
}
