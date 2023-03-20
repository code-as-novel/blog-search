package com.search.blog.common.domain.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BlogSearchResponseDto {
    private DaumMeta meta;
    private List<DaumDocument> documents;
}
