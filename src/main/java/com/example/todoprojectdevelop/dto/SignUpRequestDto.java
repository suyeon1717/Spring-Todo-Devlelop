package com.example.todoprojectdevelop.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {

    private final String userId;

    private final String password;

    private final String userName;

    private final String email;

    public SignUpRequestDto(String userId, String password, String userName, String email) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.email = email;
    }
}
