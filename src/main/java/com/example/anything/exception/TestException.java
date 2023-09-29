package com.example.anything.exception;


public class TestException extends CustomException {
    public TestException(ErrorCode errorCode) {
        super(errorCode);
    }
}
