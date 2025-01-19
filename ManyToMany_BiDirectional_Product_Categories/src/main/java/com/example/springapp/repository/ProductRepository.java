package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.springapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
    @Query(value = "select * from product p join product_category pc on pc.product_id = p.id where pc.category_id = ?1 order by p.price", nativeQuery = true)
    List<Product> getAllProduct(int categoryId);
}
