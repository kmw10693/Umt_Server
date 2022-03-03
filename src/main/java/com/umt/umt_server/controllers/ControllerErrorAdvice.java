package com.umt.umt_server.controllers;

import com.umt.umt_server.errors.CustomException;
import com.umt.umt_server.errors.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 개발자가 직접 정의한 CustomException에 대한 Handler 입니다.
 */
@RestControllerAdvice
public class ControllerErrorAdvice {

    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponse> handleCustomException(final CustomException e) {
        return ResponseEntity
                .status(e.getErrorCode().getStatus().value())
                .body(new ErrorResponse(e.getErrorCode()));
    }
}
