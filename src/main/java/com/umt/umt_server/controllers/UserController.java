package com.umt.umt_server.controllers;

import com.umt.umt_server.application.UserService;
import com.umt.umt_server.domain.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
