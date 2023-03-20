package com.search.blog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
public class DaumApiConfig {
    
    private final String prefix = "KakaoAK";

    @Value(value = prefix + " ${apis.daum.authorization}")
    String authorization;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("authorization", authorization);
        };
    }
}
