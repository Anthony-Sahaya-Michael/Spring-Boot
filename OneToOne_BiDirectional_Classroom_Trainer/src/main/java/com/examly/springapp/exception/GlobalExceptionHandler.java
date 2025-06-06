package com.examly.springapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicateClassroomException.class)
    public ResponseEntity<String> handleDuplicateClassroomException(DuplicateClassroomException e){
        return ResponseEntity.status(409).body(e.getMessage());
    }
}
