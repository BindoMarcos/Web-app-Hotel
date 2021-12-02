package com.hotelmvc.front.models;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class RestHandler {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    RestTemplate rest = new RestTemplate();
}
