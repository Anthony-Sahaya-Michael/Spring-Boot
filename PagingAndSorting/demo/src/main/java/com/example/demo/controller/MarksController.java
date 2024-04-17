package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Stud;
import com.example.demo.services.MarksService;

@RestController
public class MarksController {

    @Autowired
    private MarksService marksService;

    @GetMapping("/marks")
    public ResponseEntity<Page<Stud>> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        Page<Stud> products = marksService.getAllMarks(page, size, sortBy);
        return ResponseEntity.ok(products);
    }

}