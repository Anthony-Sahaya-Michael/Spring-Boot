package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
