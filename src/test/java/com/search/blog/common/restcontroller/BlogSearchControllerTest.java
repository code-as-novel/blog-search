package com.search.blog.common.restcontroller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import com.search.blog.common.domain.entity.BlogRank;
import com.search.blog.common.dto.BlogSearchRequestDto;
import com.search.blog.common.dto.BlogSearchResponseDto;
import com.search.blog.common.service.internal.BlogService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BlogSearchController.class)
public class BlogSearchControllerTest {

    private static final BlogSearchRequestDto REQUEST = BlogSearchRequestDto.builder()
                                                                    .query("test").build();
    private static final BlogSearchResponseDto RESPONSE = new BlogSearchResponseDto();    
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BlogService blogService;

    @Test
    void givenNormalServiceReturn_whenBlogSearch_thenStatusOK() throws Exception {

        given(blogService.search(REQUEST)).willReturn(RESPONSE);
        
        mockMvc.perform(get("/v1.0/blog-search")
                            .param("query", "test")
                            .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void givenNormalServiceReturn_whenRankSearch_thenStatusOK() throws Exception {

        given(blogService.getTopQuery()).willReturn(new ArrayList<BlogRank>());
        
        mockMvc.perform(get("/v1.0/rankings")
                            .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
