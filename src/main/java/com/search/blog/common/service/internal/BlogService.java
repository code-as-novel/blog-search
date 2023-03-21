package com.search.blog.common.service.internal;

import java.util.List;

import com.search.blog.common.domain.entity.BlogRank;
import com.search.blog.common.dto.BlogSearchRequestDto;
import com.search.blog.common.dto.BlogSearchResponseDto;

public interface BlogService {
    BlogSearchResponseDto search(final BlogSearchRequestDto blogSearchRequestDto) throws Exception;

    List<BlogRank> getTopQuery();
}
