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
    private Sort sort;
    private Integer page;
    private Integer size;

    public enum Sort{
        ACCURACY("accuracy"), RECENCY("recency");

        public String value;

        Sort(String value){
            this.value = value;
        }
    }
}
