package com.search.blog.common.dto;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class BlogSearchRequestDto {
    @NotBlank(message = "Input is mandatory")
    private String query;
    private String sort; //TODO: enum으로 수정
    private Integer page;
    private Integer size;
}
