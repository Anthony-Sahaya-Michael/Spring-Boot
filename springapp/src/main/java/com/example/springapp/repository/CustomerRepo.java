package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    
}
