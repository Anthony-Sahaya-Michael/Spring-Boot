package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.User;
import com.examly.springapp.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Boolean> registerUser(@RequestBody User user) {
        boolean isRegistered = userService.registerUser(user);
        if(isRegistered){
            return ResponseEntity.status(201).body(true);
         } 
         return ResponseEntity.status(500).body(false);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        String jwtToken = userService.authenticate(user);
        if(jwtToken != null){ 
            return ResponseEntity.ok(jwtToken);
        }
        return ResponseEntity.status(500).body(null);
    }
}
