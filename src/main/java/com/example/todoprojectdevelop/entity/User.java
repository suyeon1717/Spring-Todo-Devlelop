package com.example.todoprojectdevelop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user")
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private String userId;

//    @Column(nullable = false)
//    private String password;

    @Column(nullable = false)
    private String userName;

    @Email //import jakarta.validation.constraints.Email;
    @Column(nullable = false)
    private String email;

    // 기본 생성자 필수로 가져야 함
    public User() {
    }

    public User(String email, String userName) {
        this.userName = userName;
        this.email = email;
    }
}
