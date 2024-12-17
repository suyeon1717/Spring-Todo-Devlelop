package com.example.todoprojectdevelop.dto;

import lombok.Getter;

@Getter
public class UserUpdateRequestDto {

    private final String userName;

    private final String email;

    public UserUpdateRequestDto(String userEmail, String userName) {
        this.email = userEmail;
        this.userName = userName;
    }
}
