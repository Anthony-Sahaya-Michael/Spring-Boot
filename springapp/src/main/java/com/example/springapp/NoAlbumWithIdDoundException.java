package com.example.springapp;

public class NoAlbumWithIdDoundException extends RuntimeException{
    public NoAlbumWithIdDoundException(String message){
        super(message);
    }
}
