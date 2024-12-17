package com.example.todoprojectdevelop.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class SignUpRequestDto {

    @NotBlank
    private final String userId;

    @Email(message = "형식 : abc@naver.com")
    @NotBlank
    private final String email;

    @NotBlank
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,64}$")
    @Size(min = 8, max = 64)
    private final String password;

    @NotEmpty
    @Size(min = 1, max = 10)
    private final String userName;

    public SignUpRequestDto(String userId,  String email, String password, String userName) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.userName = userName;
    }
}
