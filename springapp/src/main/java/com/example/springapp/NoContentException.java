package com.example.springapp;

public class NoContentException extends RuntimeException{
    public NoContentException(String message){
        super(message);
    }
}
