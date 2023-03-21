package com.search.blog.common.domain.dto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class DaumMetaDto {
    private int total_count;
    private int pageable_count;
    private boolean is_end;
}
