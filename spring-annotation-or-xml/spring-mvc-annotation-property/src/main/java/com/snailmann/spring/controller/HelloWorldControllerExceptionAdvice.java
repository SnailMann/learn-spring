package com.snailmann.spring.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * 这是为HelloController提供的异常拦截切面
 *
 * @author liwenjie
 */
@ControllerAdvice(assignableTypes = HelloController.class)
public class HelloWorldControllerExceptionAdvice {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> onException(Throwable throwable){
        return ResponseEntity.badRequest().body(throwable.getMessage());
    }

}
