package com.search.blog.common.service.internal;

import java.util.List;

import com.search.blog.common.domain.dto.BlogSearchRequestDto;
import com.search.blog.common.domain.dto.BlogSearchResponseDto;
import com.search.blog.common.domain.entity.BlogRank;

public interface BlogService {
    BlogSearchResponseDto search(final BlogSearchRequestDto blogSearchRequestDto);

    List<BlogRank> getTopQuery();
}
