package com.example.todoprojectdevelop.dto;

import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private final String userId;

    private final String userName;

    private final String email;

    public SignUpResponseDto(String userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }
}
