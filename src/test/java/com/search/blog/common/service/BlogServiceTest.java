package com.search.blog.common.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.search.blog.common.repository.BlogRankRepository;
import com.search.blog.common.service.external.DaumApi;

@ExtendWith(MockitoExtension.class)
public class BlogServiceTest {
    
    @Mock
    DaumApi daumApi;

    @Mock
    BlogRankRepository blogRankRepository;

    
}
