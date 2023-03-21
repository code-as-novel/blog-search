package com.search.blog.common.domain.dto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class DaumDocumentDto {
    private String title;
    private String contents;
    private String url;
    private String datetime;    //TODO: datetime으로 수정할 것
}
