package com.search.blog.common.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.search.blog.common.domain.dto.BlogSearchRequestDto;
import com.search.blog.common.domain.dto.BlogSearchResponseDto;
import com.search.blog.common.service.internal.BlogService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BlogSearchController {
    final private BlogService blogService;

    @GetMapping (path="/v1/blog-search")
    public ResponseEntity<BlogSearchResponseDto> retrieveBlogSearch(BlogSearchRequestDto blogSearchRequestDto){
        log.info(blogSearchRequestDto.toString());
        return ResponseEntity.ok(blogService.search(blogSearchRequestDto));
    }
}
