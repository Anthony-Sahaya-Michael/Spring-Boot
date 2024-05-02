package com.questionone.newsapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.questionone.newsapi.model.Article;
import com.questionone.newsapi.model.ArticleResponse;
import com.questionone.newsapi.service.ArticleService;
// https://newsapi.org/v2/top-headlines/sources?apiKey=aeb81dd30cea48028d325f2befe5ba74
// https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=APIKEY
@RestController
public class Controller 
{
    private String APIKEY = "aeb81dd30cea48028d325f2befe5ba74";
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private ArticleService articleService;

    @GetMapping("/saveall")
    public List<Article> getResponse() 
    {
        String uri ="https://newsapi.org/v2/top-headlines?country=in&apiKey=aeb81dd30cea48028d325f2befe5ba74";

        ArticleResponse articleResponse = restTemplate.getForObject(uri, ArticleResponse.class);

        return articleService.saveAllArticeles( articleResponse.getArticles() ) ; 
        // return  articleResponse.getArticles(); 
    }
    
    
    @GetMapping("/pageSort/{pgno}/{pgsz}/{field}")
    public List<Article> getResponse(@PathVariable("pgno") int pgno,
                                     @PathVariable("pgsz") int pgsz,
                                     @PathVariable("field") String field) 
    {
        return articleService.findPageSort(pgno, pgsz, field); 
    }
    @GetMapping("/country/{country}/{category}")
    public List<Article> getcountrycategory(@PathVariable("country") String country,
                                     @PathVariable("category") String category) 
    {

        String uri ="https://newsapi.org/v2/top-headlines?country="+ country +"&category="+ category +"&apiKey=aeb81dd30cea48028d325f2befe5ba74";
        ArticleResponse articleResponse =  restTemplate.getForObject(uri, ArticleResponse.class);
        return articleResponse.getArticles(); 
    }



    
}
