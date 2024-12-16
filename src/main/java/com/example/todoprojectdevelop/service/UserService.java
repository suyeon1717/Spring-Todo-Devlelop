package com.example.todoprojectdevelop.service;

import com.example.todoprojectdevelop.dto.SignUpResponseDto;
import com.example.todoprojectdevelop.entity.User;
import com.example.todoprojectdevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 유저 생성
    public SignUpResponseDto signUp(String email, String userName) {
        User user = new User(email, userName);
        User savedUser = userRepository.save(user); // Repository에 저장

        return new SignUpResponseDto(savedUser);
    }


}
