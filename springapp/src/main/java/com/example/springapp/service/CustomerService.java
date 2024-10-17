package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Customer;
import com.example.springapp.repository.CustomerRepo;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepo customerRepo;

    public Customer addCustomerData(Customer customer) {
        return customerRepo.save(customer);
    }
}
