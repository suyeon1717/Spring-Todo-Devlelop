package com.example.todoprojectdevelop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

//    private final UserService userService;
//
//    // 유저 생성
//    @PostMapping("/signup")
//    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {
//        SignUpResponseDto signUpResponseDto = userService.signUp(
//                requestDto.getEmail(),
//                requestDto.getPassword(),
//                requestDto.getUsername()
//        );
//
//        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
//    }

}
