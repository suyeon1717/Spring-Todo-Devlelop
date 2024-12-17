package com.example.todoprojectdevelop.controller;

import com.example.todoprojectdevelop.common.Const;
import com.example.todoprojectdevelop.dto.UserResponseDto;
import com.example.todoprojectdevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class SessionHomeController {

    private final UserService userService;

    @GetMapping("/home")
    public UserResponseDto home(
            @SessionAttribute(name = Const.LOGIN_USER, required = false)
            UserResponseDto loginUser,
            Model model //import org.springframework.ui.Model;
            ) {

        if (loginUser == null) {
//            return "login";
        }

        model.addAttribute("loginUser", loginUser);
        System.out.println(loginUser.getEmail());
        return loginUser;
    }
}
