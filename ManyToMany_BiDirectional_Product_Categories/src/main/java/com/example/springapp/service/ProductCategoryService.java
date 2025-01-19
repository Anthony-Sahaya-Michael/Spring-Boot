package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Category;
import com.example.springapp.model.Product;
import com.example.springapp.repository.CategoryRepository;
import com.example.springapp.repository.ProductRepository;

@Service
public class ProductCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public Category saveCategory(Category categoryRequest) {
        return categoryRepository.save(categoryRequest);
    }

    public Product saveProductByCategoryId(int categoryId, Product productRequest) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if(category == null) return null;
        category.getProducts().add(productRequest);
        categoryRepository.save(category);
        productRequest.getCategories().add(category);
        return productRepository.save(productRequest);
    }
    // productRequest.addCategory(category);

    public Category getCategoryById(int categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    public List<Product> getProductBycategoryId(int categoryId) {
        return productRepository.getAllProduct(categoryId);
    }

    public Boolean deleteProductById(int productId) {
        if(! productRepository.existsById(productId)) return false;
        productRepository.deleteById(productId);
        return true;
    }
    
}
