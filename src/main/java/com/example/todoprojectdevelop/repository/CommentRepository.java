package com.example.todoprojectdevelop.repository;

import com.example.todoprojectdevelop.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByTodoIdOrderByModifiedAtDesc(Long todoId);
    List<Comment> findByUserIdOrderByModifiedAtDesc(Long userId);

    // 선택 댓글 조회
    default Comment findByCommentIdOrElseThrow(Long commentId) {
        return findById(commentId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exitst id = " + commentId));
    }

}
