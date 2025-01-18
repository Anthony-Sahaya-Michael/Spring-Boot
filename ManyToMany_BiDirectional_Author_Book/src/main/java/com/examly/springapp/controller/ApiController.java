package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Author;
import com.examly.springapp.model.Book;
import com.examly.springapp.service.ApiService;

@RestController
public class ApiController {
    @Autowired
    private ApiService apiService;

    @PostMapping("/author")
    public ResponseEntity<Boolean> addNewAuthor(@RequestBody Author author){
        Author obj = apiService.addNewAuthor(author);
        if(obj != null){
            return ResponseEntity.status(201).body(true);
        }
        return ResponseEntity.status(201).body(false);
    }

    @PostMapping("/author/{authorId}/book")
    public ResponseEntity<Boolean> addNewBookWithAuthorId(@PathVariable("authorId") int id, @RequestBody Book book){
        return ResponseEntity.status(201).body(true);
    }

    @GetMapping("/author")
    public ResponseEntity<List<Author>> getAllAuthors(){
        return ResponseEntity.status(200).body(apiService.getAllAuthors());
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<Author> getAuthorById(@PathVariable int authorId){
        return ResponseEntity.status(200).body(apiService.getAuthorById(authorId));
    }

    @PutMapping("/author/{authorId}/book/{bookId}")
    public ResponseEntity<Book> updateBookWithBookIdAndAuthorId(@PathVariable int authorId, @PathVariable int bookId, @RequestBody Book book){
        return ResponseEntity.status(200).body(apiService.updateBookWithBookIdAndAuthorId(authorId, bookId, book));
    }
}
