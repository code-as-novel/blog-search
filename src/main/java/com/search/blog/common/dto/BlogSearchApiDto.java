package com.search.blog.common.dto;

import java.util.Optional;

import com.search.blog.common.dto.BlogSearchRequestDto.Sort;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BlogSearchApiDto {
    private String query;
    private String sort;
    private Integer page;
    private Integer size;

    public static BlogSearchApiDto of(BlogSearchRequestDto blogSearchRequestDto){
        return BlogSearchApiDto.builder()
                               .query(blogSearchRequestDto.getQuery())
                               .sort(Optional.ofNullable(blogSearchRequestDto.getSort()).orElse(Sort.ACCURACY).value)
                               .page(blogSearchRequestDto.getPage())
                               .size(blogSearchRequestDto.getSize())
                               .build();
    }
}
