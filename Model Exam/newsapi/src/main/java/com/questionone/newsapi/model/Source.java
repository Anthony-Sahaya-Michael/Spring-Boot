package com.questionone.newsapi.model;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Source {
    @Id
    private String name; 
    private String id;
}


/* 


"source": {
                "id": "the-times-of-india",
                "name": "The Times of India"
            },
 */