package com.example.todoprojectdevelop.repository;

import com.example.todoprojectdevelop.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByTodoIdOrderByModifiedAtDesc(Long todoId);
    List<Comment> findByUserIdOrderByModifiedAtDesc(Long userId);

}
