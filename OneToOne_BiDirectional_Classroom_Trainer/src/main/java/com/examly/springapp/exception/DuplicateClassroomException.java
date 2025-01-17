package com.examly.springapp.exception;

public class DuplicateClassroomException extends RuntimeException {
    public DuplicateClassroomException(String message){
        super(message);
    }
}
