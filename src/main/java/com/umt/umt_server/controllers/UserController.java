package com.umt.umt_server.controllers;

import com.umt.umt_server.application.UserService;
import com.umt.umt_server.domain.User;
import com.umt.umt_server.dto.User.UserResultData;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 사용자의 HTTP 요청을 처리하는 클래스입니다.
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ApiOperation(value = "사용자 등록", notes = "사용자의 정보를 받아 등록합니다.")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping
    @ApiOperation(value = "마이 페이지 불러오기", notes = "사용자 index를 받아, 마이 페이지를 불러옵니다.")
    public UserResultData getMyPage(@RequestParam("id") Long userId) {
        return userService.getMyPage(userId);
    }

}
