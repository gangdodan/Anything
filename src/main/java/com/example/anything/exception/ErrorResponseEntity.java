package com.example.anything.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@RequiredArgsConstructor
public class ErrorResponseEntity {
    private final int status;
    private final String code;
    private final String message;

    public static ResponseEntity<ErrorResponseEntity> of(CustomException e){
        HttpStatus status = e.getErrorCode().getStatus();
        String message = e.getErrorCode().getMessage();
        return ResponseEntity.status(status)
                .body(new ErrorResponseEntity(status.value(), status.toString(), message));
    }

}
