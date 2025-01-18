package com.examly.springapp.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Author;
import com.examly.springapp.model.Book;
import com.examly.springapp.repository.AuthorRepo;
import com.examly.springapp.repository.BookRepo;

@Service
public class ApiService {
    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private BookRepo bookRepo;

    public Author addNewAuthor(Author author){
        return authorRepo.save(author);
    }

    public Book addNewBookWithAuthorId(int authorId, Book book){
        Author author = authorRepo.findById(authorId).orElse(null);
        book.getAuthor().add(author);
        bookRepo.save(book);
        return book;
    }

    public List<Author> getAllAuthors(){
        return authorRepo.findAll();
    }

    public Author getAuthorById(int id){
        return authorRepo.findById(id).orElse(null);
    }

    public Book updateBookWithBookIdAndAuthorId(int authorId, int bookId, Book book){
        Book obj = bookRepo.findById(bookId).orElse(null);
        if(obj != null){
            obj.setName(book.getName());
            // Author author = authorRepo.findById(authorId).orElse(null);
            // obj.getAuthor().add(author);
            bookRepo.save(obj);
        }
        return obj;
    }
}
