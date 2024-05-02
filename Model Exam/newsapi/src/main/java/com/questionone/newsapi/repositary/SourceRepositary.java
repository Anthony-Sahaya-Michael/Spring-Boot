package com.questionone.newsapi.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.questionone.newsapi.model.Source;

public interface SourceRepositary  extends JpaRepository<Source, String>
{

}
