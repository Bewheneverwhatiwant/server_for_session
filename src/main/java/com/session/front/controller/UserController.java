package com.session.front.controller;

import com.session.front.domain.*;
import com.session.front.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입 API
    @PostMapping("/signup")
    public String createUser(@RequestBody CreateUserReqDto dto) {
        userService.createUser(dto);
        return "회원가입이 완료되었습니다.";
    }

    // 로그인 API
    @PostMapping("/login")
    public Long loginUser(@RequestBody LoginUserReqDto dto) {
        return userService.loginUSer(dto);
    }

    // 비밀번호 변경 API
    @PutMapping("/password")
    public String changeUserPassword(@RequestBody UpdateUserPasswordReqDto dto) {
        userService.changeUserPassword(dto);
        return "비밀번호가 변경되었습니다.";
    }

    // 회원탈퇴 API
    @DeleteMapping("/delete")
    public String deleteUser(@RequestBody DeleteUserReqDto dto) {
        userService.deleteUser(dto);
        return "회원탈퇴가 완료되었습니다.";
    }
}
