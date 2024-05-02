package com.questionone.newsapi.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Article 
{
    @Id
    // @Column(columnDefinition="TEXT")
    private String title;

    private String author;
    @Column(columnDefinition="TEXT")
    private String description;
    @Column(columnDefinition="TEXT")
    private String url;
    @Column(columnDefinition="TEXT")
    private String urlToImage;
    @Column(columnDefinition="TEXT")
    private String publishedAt;
    @Column(columnDefinition="TEXT")
    private String content;
    
    // Data too long for column 'url' at row 1] [insert into article (author,content,description,published_at,url,url_to_image,title) v
    // @JsonBackReference
    // @ManyToOne
    // private Source source; 
}


/* 

{
    "status": "ok",
    "totalResults": 38,
    "articles": [
        {
            "source": {
                "id": "the-times-of-india",
                "name": "The Times of India"
            },
            "author": "ET Telecom",
            "title": "Apple launches MacBook Air laptops with faster M3 chips - ETTelecom",
            "description": "The new MacBook Air models come with 13-inch and 15-inch screen sizes and are up to 60% faster than the model with Apple's M1 processor, the company said on its website.",
            "url": "https://telecom.economictimes.indiatimes.com/news/devices/apple-launches-macbook-air-laptops-with-faster-m3-chips/108219581",
            "urlToImage": "https://etimg.etb2bimg.com/thumb/msid-108219581,imgsize-19524,width-1200,height=765,overlay-ettelecom/devices/apple-launches-macbook-air-laptops-with-faster-m3-chips.jpg",
            "publishedAt": "2024-03-05T02:32:59Z",
            "content": "Apple on Monday unveiled a pair of new MacBook Air laptops with its latest M3 processors, betting that the more powerful models would attract consumers looking to upgrade to artificial intelligence-p… [+774 chars]"
        }
    ]
}
 */