package com.search.blog.common.restcontroller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.search.blog.common.domain.entity.BlogRank;
import com.search.blog.common.dto.BlogSearchRequestDto;
import com.search.blog.common.dto.BlogSearchResponseDto;
import com.search.blog.common.service.internal.BlogService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BlogSearchController {
    final private BlogService blogService;

    @GetMapping (path="/v1.0/blog-search")
    public ResponseEntity<BlogSearchResponseDto> retrieveBlogSearch(
                    @Validated BlogSearchRequestDto blogSearchRequestDto) throws Exception {
        return ResponseEntity.ok(blogService.search(blogSearchRequestDto));
    }

    @GetMapping (path="/v1.{minor_version:[0-9]}/rankings")
    public ResponseEntity<List<BlogRank>> retrieveSearchRank(){
        return ResponseEntity.ok(blogService.getTopQuery());
    }
}
