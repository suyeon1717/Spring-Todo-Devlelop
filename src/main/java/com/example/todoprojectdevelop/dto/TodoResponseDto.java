package com.example.todoprojectdevelop.dto;

import com.example.todoprojectdevelop.entity.Todo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoResponseDto {
    private final Long todoId;

    private final String title;

    private final String contents;

    private final String userName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime modifiedAt;

    public TodoResponseDto(Todo todo) {
        this.todoId = todo.getTodo_id();
        this.title = todo.getTitle();
        this.contents = todo.getContents();
        this.userName = todo.getUserName();
        this.createdAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
    }
}
