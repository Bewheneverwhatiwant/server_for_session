package com.session.front.controller;

import jakarta.persistence.EntityExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler({RuntimeException.class})
    public String handleBaseException(Exception e){
        return "오류임";
    }

    @ExceptionHandler({EntityExistsException.class})
    public ResponseEntity<String> handleDuplicateException(EntityExistsException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
}
