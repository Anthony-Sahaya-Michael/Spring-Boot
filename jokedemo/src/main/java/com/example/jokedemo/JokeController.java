package com.example.jokedemo;

import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Generated;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class JokeController {
    @Autowired
    JokeService jokeService;

    @GetMapping("/api/jokes/categories")
    public List<String> getJokeCategories() {
        return jokeService.getJokeCategories();
    }

    @GetMapping("/api/jokes/random/{category}")
    public String getJokesbyCategory(@PathVariable String category) {
        return jokeService.getJokesbyCategory(category);
    }

    @GetMapping("/api/jokes/search/{query}")
    public String getMethodName(@PathVariable String query) {
        return jokeService.getsearch(query);
    }
    
    @GetMapping("/api/jokes/random/{query1}/{query2}")
    public String jokesinclude(@PathVariable String query1,@PathVariable String query2) {
        return jokeService.getjokesinclude(query1,query2);
    }
    
    
}
