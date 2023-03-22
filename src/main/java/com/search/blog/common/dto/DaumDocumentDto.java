package com.search.blog.common.dto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class DaumDocumentDto {
    private String title;
    private String contents;
    private String url;
    private String datetime;
}
