package com.example.anything.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TargetController {
    @GetMapping("/ex")
    public void exTest(){
        throw new CustomException(ErrorCode.TEST_CODE);
    }
    @GetMapping("/ex2")
    public void exTest2(){
        throw new TestException(ErrorCode.TEST_CODE);
    }
}
