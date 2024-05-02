package com.questionone.newsapi.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.questionone.newsapi.model.Article;

public interface ArticleRepositary extends JpaRepository<Article, String>
{
    
}
