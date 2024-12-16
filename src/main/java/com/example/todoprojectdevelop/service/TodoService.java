package com.example.todoprojectdevelop.service;

import com.example.todoprojectdevelop.dto.TodoResponseDto;
import com.example.todoprojectdevelop.entity.Todo;
import com.example.todoprojectdevelop.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
//    private final UserRepository userRepository;

    // 일정 생성
    public TodoResponseDto save(String title, String contents, String userName) {

        Todo todo = new Todo(title, contents, userName);
        Todo savedTodo = todoRepository.save(todo);

        return new TodoResponseDto(savedTodo.getTodo_id(), savedTodo.getTitle(), savedTodo.getContents(), savedTodo.getUserName());
    }

}
