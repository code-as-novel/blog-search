package com.search.blog.common.service.internal;

import com.search.blog.common.domain.dto.BlogSearchRequestDto;
import com.search.blog.common.domain.dto.BlogSearchResponseDto;

public interface BlogService {
    BlogSearchResponseDto search(final BlogSearchRequestDto blogSearchRequestDto);
}
