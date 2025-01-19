package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Category;
import com.example.springapp.model.Product;
import com.example.springapp.service.ProductCategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final ProductCategoryService productCategoryService;
    
    @PostMapping("/categories")
    public ResponseEntity<Category> saveCategory(@RequestBody Category categoryRequest) {
        return ResponseEntity.status(201).body(productCategoryService.saveCategory(categoryRequest));
    }
    
    @PostMapping("/categories/{categoryId}/product")
    public ResponseEntity<Product> saveProductByCategoryId(@PathVariable int categoryId, @RequestBody Product productRequest) {
        return ResponseEntity.status(201).body(productCategoryService.saveProductByCategoryId(categoryId, productRequest));
    }
   
    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int categoryId) {
        return ResponseEntity.ok(productCategoryService.getCategoryById(categoryId));
    }

    @GetMapping("/categories/{categoryId}/product/asc-price")
    public ResponseEntity<List<Product>> getProductBycategoryId(@PathVariable int categoryId){
        return ResponseEntity.ok(productCategoryService.getProductBycategoryId(categoryId));
    }

    @DeleteMapping("categories/product/{productId}")
    public ResponseEntity<Boolean> deleteProductById(@PathVariable int productId){
        return ResponseEntity.ok(productCategoryService.deleteProductById(productId));
    }
}