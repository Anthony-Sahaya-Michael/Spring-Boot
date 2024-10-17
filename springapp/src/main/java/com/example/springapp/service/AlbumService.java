package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.AlbumNotFoundException;
import com.example.springapp.NoAlbumWithIdDoundException;
import com.example.springapp.NoContentException;
import com.example.springapp.model.Album;
import com.example.springapp.repository.AlbumRepo;


@Service
public class AlbumService {
    @Autowired
    private AlbumRepo albumRepo;

    public Album addAlbumInformation(Album album) {
        // if(album.getAlbumName().isEmpty()){
        //     throw new AlbumNotFoundException("Not Found");
        // }
        return albumRepo.save(album);
    }
    
    public List<Album> getAllAlbumInformation() {
        List<Album> al = albumRepo.findAll();
        if(al.isEmpty()){
            throw new NoContentException("No Album is there");
        }
        return al;
    }

    public Album getAllAlbumInformation(int albumId) {
        return albumRepo.findById(albumId).orElseThrow(() -> new NoAlbumWithIdDoundException("Album not found"));
    }
}
