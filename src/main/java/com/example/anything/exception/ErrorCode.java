package com.example.anything.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.CONFLICT;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    TEST_CODE(CONFLICT,"test 나와라 콩");

    private final HttpStatus status;
    private final String message;
}
