package com.example.jokedemo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {    // instantiating resttemplete object
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
