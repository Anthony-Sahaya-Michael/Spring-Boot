package com.example.springapp;

public class AlbumNotFoundException extends RuntimeException{
    public AlbumNotFoundException(String message){
        super(message);
    }
}
