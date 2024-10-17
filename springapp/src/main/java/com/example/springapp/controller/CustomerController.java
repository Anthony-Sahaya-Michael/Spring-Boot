package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Customer;
import com.example.springapp.service.CustomerService;

@RestController
@RequestMapping
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<Customer> addCustomerData(@RequestBody Customer customer){
        Customer obj = customerService.addCustomerData(customer);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
