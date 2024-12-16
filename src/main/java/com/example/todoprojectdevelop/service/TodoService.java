package com.example.todoprojectdevelop.service;

import com.example.todoprojectdevelop.dto.TodoResponseDto;
import com.example.todoprojectdevelop.entity.Todo;
import com.example.todoprojectdevelop.repository.TodoRepository;
import com.example.todoprojectdevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository; // Todo N : User 1 연관 관계

    // 일정 생성
    public TodoResponseDto save(String title, String contents, String userName) {

        Todo todo = new Todo(title, contents, userName);
        Todo savedTodo = todoRepository.save(todo); // Repository에 저장

        return new TodoResponseDto(savedTodo);
    }

    // 전체 일정 조회 : case 4개
    public List<TodoResponseDto> findTodoByModifiedAtBetweenOrUserName(String modifiedAt, String userName) {
        LocalDate date = null;
        if(modifiedAt != null)
            date = LocalDate.parse(modifiedAt, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        // LocalDate를 LocalDateTime으로 변환 (하루의 시작과 끝)
        LocalDateTime startOfDay = (date != null) ? date.atStartOfDay() : null;
        LocalDateTime endOfDay = (date != null) ? date.atTime(23, 59, 59, 999999) : null;

        List<Todo> todoList = todoRepository.findTodoByModifiedAtBetweenOrUserName(startOfDay, endOfDay, userName);

        List<TodoResponseDto> todoResponseDtoList =
                todoList.stream()
                .map(todo -> new TodoResponseDto(todo))
                .collect(Collectors.toList());
        return todoResponseDtoList;
    }

    // 선택 일정 조회
    public TodoResponseDto findBytodoId(Long todoId) {
        Todo todo = todoRepository.findBytodoIdOrElseThrow(todoId);
        return new TodoResponseDto(todo);
    }

    // 선택 일정 수정
    @Transactional
    public TodoResponseDto updateTodo(Long todoId, String title, String contents) {
        Todo todo = todoRepository.findBytodoIdOrElseThrow(todoId);

        // 제목 수정
        if(title != null){
            todo.updateTitle(title);
        }
        // 내용 수정
        if(contents != null){
            todo.updateContents(contents);
        }

        todoRepository.flush(); //todoRepository.save(todo) XX 영솏성 문제

        return new TodoResponseDto(todo);

    }

    // 선택 일정 삭제
    public void deleteTodo(Long todoId) {
        Todo todo = todoRepository.findBytodoIdOrElseThrow(todoId);

        todoRepository.delete(todo);
//        todoRepository.deleteById(todoId);
    }

}
