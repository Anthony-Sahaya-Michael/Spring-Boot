package com.example.jokedemo;

import java.util.List;

// import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {
    String base_URL="https://api.chucknorris.io/";

 //class in the Spring Framework that simplifies the process of making HTTP requests and processing the responses.
 private final RestTemplate restTemplate;

    public JokeService(RestTemplate restTemplate) {  //constructor to initialize testTemplete object
        this.restTemplate = restTemplate;
    }

    //get List of joke categories
    @SuppressWarnings("unchecked")
    public List<String> getJokeCategories()
    { String url= base_URL+ "jokes/categories";  // appending endpoint with baseurl
    return restTemplate.getForObject(url, List.class);  // make a GET request to a specified URI and return the response body as an object of the specified type 
    }

    @SuppressWarnings("unchecked")  
    public String getJokesbyCategory(String catregory)
    { String url= base_URL+ "jokes/random?category="+catregory;  // appending endpoint with baseurl
    return restTemplate.getForObject(url, String.class);  // make a GET request to a specified URI and return the response body as an object of the specified type 
    }

    @SuppressWarnings("unchecked")  
    public String getsearch(String query)
    { String url= base_URL+ "jokes/search?query="+query;  // appending endpoint with baseurl
    return restTemplate.getForObject(url, String.class);  // make a GET request to a specified URI and return the response body as an object of the specified type 
    }
    
    @SuppressWarnings("unchecked")  
    public String getjokesinclude(String query1,String query2)
    { String url= base_URL+ "jokes/random?include="+query1+","+query2;  // appending endpoint with baseurl
    return restTemplate.getForObject(url, String.class);  // make a GET request to a specified URI and return the response body as an object of the specified type 
    }

}
