package com.example.todoprojectdevelop.dto;

import com.example.todoprojectdevelop.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private final Long userId;

    private final String email;

    private final String userName;

    public UserResponseDto(User user) {
        this.userId = user.getId();
        this.email = user.getEmail();
        this.userName = user.getUserName();
    }
}
