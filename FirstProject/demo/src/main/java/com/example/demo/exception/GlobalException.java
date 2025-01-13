package com.example.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice
public class GlobalException {
    // @ExceptionHandler(DuplicateEmployeeException.class)
    // public ResponseEntity<String> handleDuplicateEmployeeException(DuplicateEmployeeException ex){
    //     return ResponseEntity.status(400).body(ex.getMessage());
    // }
}
