package com.search.blog.common.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.search.blog.common.domain.dto.BlogSearchRequestDto;
import com.search.blog.common.domain.dto.BlogSearchResponseDto;
import com.search.blog.config.DaumApiConfig;

@FeignClient(value="daum", url="${apis.daum.url}", configuration=DaumApiConfig.class)
public interface DaumApi {
    @GetMapping(value="/${apis.daum.blog.version}${apis.daum.blog.api}", produces = "application/json")
    BlogSearchResponseDto getDaumBlogSearch(@SpringQueryMap BlogSearchRequestDto blogSearchRequestDto);
}
