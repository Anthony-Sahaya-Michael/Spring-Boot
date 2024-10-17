package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Album;
import com.example.springapp.service.AlbumService;

@RestController
@RequestMapping
public class AlbumController {

    @Autowired
    private AlbumService albumService;


    @PostMapping("/album")
    public ResponseEntity<Album> addAlbumInformation(@RequestBody Album album){
        Album obj = albumService.addAlbumInformation(album);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @GetMapping("/album")
    public ResponseEntity<List<Album>> getAllAlbumInformation(){
        List<Album> al = albumService.getAllAlbumInformation();
        return new ResponseEntity<>(al, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/album/{albumId}")
    public ResponseEntity<Album> getAlbumUsingId(@PathVariable int albumId){
        Album obj = albumService.getAllAlbumInformation(albumId);
        return new ResponseEntity<>(obj, HttpStatusCode.valueOf(200));
    }

}
