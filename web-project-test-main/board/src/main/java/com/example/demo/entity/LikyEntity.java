package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.example.demo.entity.primaryKey.LikyPK;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Liky")
@Table(name = "Liky")
@IdClass(LikyPK.class)
public class LikyEntity {
    @Id
    private int boardNumber;
    @Id
    private String userEmail;
    private String UserNickname;
    private String userProfileUrl;

    public void patchProfile(String profileUrl) {
        this.userProfileUrl = profileUrl;
    }
}
