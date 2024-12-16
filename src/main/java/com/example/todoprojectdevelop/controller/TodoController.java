package com.example.todoprojectdevelop.controller;

import com.example.todoprojectdevelop.dto.CreateTodoRequestDto;
import com.example.todoprojectdevelop.dto.TodoResponseDto;
import com.example.todoprojectdevelop.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    // 일정 생성 Controller
    @PostMapping
    public ResponseEntity<TodoResponseDto> save(@RequestBody CreateTodoRequestDto requestDto) {

        TodoResponseDto todoResponseDto = todoService.save(
                requestDto.getTitle(),
                requestDto.getContents(),
                requestDto.getUserName()
        );

        return new ResponseEntity<>(todoResponseDto, HttpStatus.CREATED);
    }
}
