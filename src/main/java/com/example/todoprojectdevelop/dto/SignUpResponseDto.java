package com.example.todoprojectdevelop.dto;

import com.example.todoprojectdevelop.entity.User;
import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private final Long userId;

    private final String userName;

    private final String email;

    public SignUpResponseDto(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
    }
}
