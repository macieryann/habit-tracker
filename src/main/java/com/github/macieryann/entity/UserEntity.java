//package com.github.macieryann.entity;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "users")
//public class UserEntity {
//    //CREATE TABLE users (
//    //    user_id SERIAL PRIMARY KEY,
//    //    username VARCHAR(255) NOT NULL UNIQUE,
//    //    password VARCHAR(255) NOT NULL
//    //);
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long userId;
//    @Column(nullable = false)
//    private String username;
//    @Column(nullable = false)
//    private String password;
//
//    public UserEntity(Long userId, String username, String password) {
//        this.userId = userId;
//        this.username = username;
//        this.password = password;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//}
