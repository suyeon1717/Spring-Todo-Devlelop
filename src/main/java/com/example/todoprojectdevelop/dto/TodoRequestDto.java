package com.example.todoprojectdevelop.dto;

import lombok.Getter;

@Getter
public class TodoRequestDto {

    private final String title;

    private final String contents;

    private final Long userId;

    public TodoRequestDto(String title, String contents, Long userId) {
        this.title = title;
        this.contents = contents;
        this.userId = userId;
    }
}
