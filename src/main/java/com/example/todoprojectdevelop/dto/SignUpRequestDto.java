package com.example.todoprojectdevelop.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {

    private final String userId;

    private final String email;

    private final String password;

    private final String userName;

    public SignUpRequestDto(String userId,  String email, String password, String userName) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.userName = userName;
    }
}
