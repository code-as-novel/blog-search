package com.search.blog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.search.blog.constant.HeaderConstant;

import feign.RequestInterceptor;

@Configuration
public class DaumApiConfig {
    
    @Value(value = HeaderConstant.AUTHORIZATION_PREFIX + " ${apis.daum.authorization}")
    String authorization;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(HeaderConstant.HEADER_AUTHORIZATION, authorization);
        };
    }
}
