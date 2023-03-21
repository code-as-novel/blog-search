package com.search.blog.common.restcontroller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.search.blog.common.domain.dto.BlogSearchRequestDto;
import com.search.blog.common.domain.dto.BlogSearchResponseDto;
import com.search.blog.common.domain.entity.BlogRank;
import com.search.blog.common.service.internal.BlogService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BlogSearchController {
    final private BlogService blogService;

    @GetMapping (path="/v1.{minor_version:[0-9]}/blog-search")
    public ResponseEntity<BlogSearchResponseDto> retrieveBlogSearch(BlogSearchRequestDto blogSearchRequestDto){
        return ResponseEntity.ok(blogService.search(blogSearchRequestDto));
    }

    @GetMapping (path="/v1.{minor_version:[0-9]}/rankings")
    public ResponseEntity<List<BlogRank>> retrieveSearchCount(){
        return ResponseEntity.ok(blogService.getTopQuery());
    }
}
