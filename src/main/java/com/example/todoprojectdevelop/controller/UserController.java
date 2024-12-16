package com.example.todoprojectdevelop.controller;

import com.example.todoprojectdevelop.dto.SignUpRequestDto;
import com.example.todoprojectdevelop.dto.SignUpResponseDto;
import com.example.todoprojectdevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 유저 생성
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {
        SignUpResponseDto signUpResponseDto = userService.signUp(
                requestDto.getEmail(),
                requestDto.getUserName()
        );

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

}
