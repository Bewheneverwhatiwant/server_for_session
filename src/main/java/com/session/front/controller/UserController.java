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
    public ResponseEntity<String> createUser(@RequestBody CreateUserReqDto dto) {
        try {
            userService.createUser(dto);
            return ResponseEntity.ok("회원가입이 완료되었습니다.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 로그인 API
    @PostMapping("/login")
    public ResponseEntity<Long> loginUser(@RequestBody LoginUserReqDto dto) {
        try {
            Long userId = userService.loginUSer(dto);
            return ResponseEntity.ok(userId);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // 비밀번호 변경 API
    @PutMapping("/password")
    public ResponseEntity<String> changeUserPassword(@RequestBody UpdateUserPasswordReqDto dto) {
        try {
            userService.changeUserPassword(dto);
            return ResponseEntity.ok("비밀번호가 변경되었습니다.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 회원탈퇴 API
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestBody DeleteUserReqDto dto) {
        try {
            userService.deleteUser(dto);
            return ResponseEntity.ok("회원탈퇴가 완료되었습니다.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
