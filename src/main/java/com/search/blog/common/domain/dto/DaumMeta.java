package com.search.blog.common.domain.dto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class DaumMeta {
    private int total_count;
    private int pageable_count;
    private boolean is_end;
}
