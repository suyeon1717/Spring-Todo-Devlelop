package com.example.todoprojectdevelop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class TodoRequestDto {

    @NotNull
    @Size(min = 1, max = 20)
    private final String title;

    @Size(max = 300)
    private final String contents;

    @NotBlank
    private final Long userId;

    public TodoRequestDto(String title, String contents, Long userId) {
        this.title = title;
        this.contents = contents;
        this.userId = userId;
    }
}
