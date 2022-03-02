package com.umt.umt_server.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ErrorCode에 직접 정의한 Custom 예외를 처리할 Exception 클래스 입니다.
 */
@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {

    private final ErrorCode errorCode;

}
