package com.example.todoprojectdevelop.dto;

import lombok.Getter;

@Getter
public class TodoResponseDto {
    private final Long id;

    private final String title;

    private final String contents;

    private final String userName;

    public TodoResponseDto(Long id, String title, String contents, String userName) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.userName = userName;
    }
}
