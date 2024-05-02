package com.questionone.newsapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.questionone.newsapi.model.Article;
import com.questionone.newsapi.repositary.ArticleRepositary;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepositary articleRepositary;

    public List<Article> saveAllArticeles( List<Article> articles )
    {
        return articleRepositary.saveAll(articles);
    }

    public List<Article> findPageSort(int pgNo,int pageSize, String field)
    {
        return articleRepositary.findAll(PageRequest.of(pgNo, pageSize).withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
        
    }
}
