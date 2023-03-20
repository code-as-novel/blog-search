package com.search.blog.common.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class BlogSearchRequestDto {
    private String query;
    private String sort; //TODO: enum으로 수정
    private Integer page;
    private Integer size;
}
