package com.umt.umt_server.controllers;

import com.umt.umt_server.application.SessionService;
import com.umt.umt_server.dto.Jwt.TokenRes;
import com.umt.umt_server.dto.Session.LoginReq;
import com.umt.umt_server.dto.Session.SignupReq;
import com.umt.umt_server.dto.Session.SignupRes;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/session")
@RequiredArgsConstructor
public class SessionController
{
    private final SessionService sessionService;

    @ApiOperation(value = "회원가입", notes = "회원가입 요청 데이터를 받아 회원가입을 합니다.")
    @PostMapping("/signup")
    public SignupRes signup(@RequestBody @Valid SignupReq signupReq) {
        return sessionService.signup(signupReq);
    }

    @ApiOperation(value = "로그인", notes = "이메일과 비밀번호를 받아 로그인을 합니다.")
    @PostMapping("/login")
    public TokenRes login(@RequestBody @Valid LoginReq loginReq) {
        return sessionService.login(loginReq);
    }

}
