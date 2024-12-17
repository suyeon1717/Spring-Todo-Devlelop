package com.example.todoprojectdevelop.controller;

import com.example.todoprojectdevelop.common.Const;
import com.example.todoprojectdevelop.dto.LoginRequestDto;
import com.example.todoprojectdevelop.dto.UserResponseDto;
import com.example.todoprojectdevelop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class SessionUserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(
            @RequestBody LoginRequestDto dto,
            HttpServletRequest request
    ) {
        if(!userService.login(dto.getEmail(), dto.getPassword())) { // 로그인 실행
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); // 실패시 예외처리 : HTTP Status code 401을 반환
        }

        // 로그인 성공시 로직
        HttpSession session = request.getSession();

        // 유저 정보 조회
        UserResponseDto loginUser = userService.findByEmail(dto.getEmail());

        // Session에 로그인 유저 정보를 저장
        session.setAttribute(Const.LOGIN_USER, loginUser);

        // 로그인 성공 시 리다이렉트
        return new ResponseEntity<>(loginUser, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if(session == null){
            log.info("로그인 상태가 아닙니다.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // 세션 값 삭제
        session.removeAttribute(Const.LOGIN_USER);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}