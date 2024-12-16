package com.example.todoprojectdevelop.repository;

import com.example.todoprojectdevelop.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
