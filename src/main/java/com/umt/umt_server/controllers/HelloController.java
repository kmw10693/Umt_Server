package com.umt.umt_server.controllers;

import com.umt.umt_server.errors.CustomException;
import com.umt.umt_server.errors.ErrorCode;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 사용자의 HTTP 요청을 처리하는 클래스입니다.
 */
@RestController
@RequestMapping
public class HelloController {

    @ApiOperation(value= "테스트 확인", notes= "테스트용 컨트롤러입니다.")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public String sayHello() { return "Hello world!"; }

    @ApiOperation(value= "예외 처리 확인", notes= "예외 처리용 테스트입니다.")
    @GetMapping("/test")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void test() {
        throw new CustomException(ErrorCode.POST_NOT_FOUND);
    }
}
