//package com.example.todoprojectdevelop.entity;
//
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import jakarta.validation.constraints.Email;
//import lombok.Getter;
//
//@Getter
//@Entity
//@Table(name = "user")
//public class User extends BaseEntity{
//
//    @Id
//    @Column(nullable = false, unique = true)
//    private String userId;
//
//    @Column(nullable = false)
//    private String password;
//
//    @Column(nullable = false)
//    private String userName;
//
//    @Email //import jakarta.validation.constraints.Email;
//    @Column(nullable = false, unique = true)
//    private String email;
//
//    // 기본 생성자 필수로 가져야 함
//    public User() {
//    }
//
//    public User(String userId, String password, String userName, String email) {
//        this.userId = userId;
//        this.password = password;
//        this.userName = userName;
//        this.email = email;
//    }
//}
