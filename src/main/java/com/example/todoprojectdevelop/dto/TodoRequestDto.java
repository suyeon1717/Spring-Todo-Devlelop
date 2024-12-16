package com.example.todoprojectdevelop.dto;

import lombok.Getter;

@Getter
public class TodoRequestDto {

    private final String title;

    private final String contents;

    private final String userName;

    public TodoRequestDto(String title, String contents, String userName) {
        this.title = title;
        this.contents = contents;
        this.userName = userName;
    }
}
