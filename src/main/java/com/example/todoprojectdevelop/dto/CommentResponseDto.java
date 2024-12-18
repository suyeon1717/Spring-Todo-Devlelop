package com.example.todoprojectdevelop.dto;

import com.example.todoprojectdevelop.entity.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private final Long todoId;

    private final Long commentId;

    private final Long userId;

    private final String contents;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime modifiedAt;

    public CommentResponseDto(Comment comment) {
        this.todoId = comment.getTodo().getId();
        this.commentId = comment.getId();
        this.userId = comment.getUser().getId();
        this.contents = comment.getContents();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
