package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {
    
}
