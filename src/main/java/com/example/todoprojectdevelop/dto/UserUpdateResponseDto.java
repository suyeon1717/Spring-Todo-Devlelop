package com.example.todoprojectdevelop.dto;

import lombok.Getter;

@Getter
public class UserUpdateResponseDto {

    private final String userName;

    private final String email;

    public UserUpdateResponseDto(String userEmail, String userName) {
        this.email = userEmail;
        this.userName = userName;
    }
}
