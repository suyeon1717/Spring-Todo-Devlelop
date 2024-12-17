package com.example.todoprojectdevelop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class LoginRequestDto {

    // 이메일과 비밀번호로 로그인
    @Email
    private final String email;

    @NotNull
    private final String password;

    public LoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
