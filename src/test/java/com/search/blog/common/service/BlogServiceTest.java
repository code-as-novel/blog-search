package com.search.blog.common.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.search.blog.common.domain.entity.BlogRank;
import com.search.blog.common.repository.BlogRankRepository;
import com.search.blog.common.service.external.DaumApi;
import com.search.blog.common.service.internal.BlogServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BlogServiceTest {
    
    @InjectMocks
    private BlogServiceImpl service;

    @Mock
    DaumApi daumApi;

    @Mock
    BlogRankRepository blogRankRepository;

    @Test
    public void givenNormalInput_whenGetTopQuery_thenReturnData() throws Exception{

        when(blogRankRepository.findTop10ByOrderByCountDesc())
            .thenReturn(List.of(new BlogRank()));

        assertNotNull(service.getTopQuery());
    }
}
