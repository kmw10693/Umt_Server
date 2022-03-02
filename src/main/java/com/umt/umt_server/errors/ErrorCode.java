package com.umt.umt_server.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 직접 정의한 Custom 예외를 관리하기 위한 클래스 입니다.
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {

    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "게시글 정보를 찾을 수 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저 정보를 찾을 수 없습니다.");

    private final HttpStatus Status;
    private final String message;

}
