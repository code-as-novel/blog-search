package com.search.blog.common.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.search.blog.common.dto.BlogSearchApiDto;
import com.search.blog.common.dto.BlogSearchResponseDto;
import com.search.blog.config.DaumApiConfig;

@FeignClient(value="daum-blog", url="${apis.daum.url}", configuration=DaumApiConfig.class)
public interface DaumApi {
    @GetMapping(value="/${apis.daum.blog.version}${apis.daum.blog.api}", produces = "application/json")
    BlogSearchResponseDto getDaumBlogSearch(@SpringQueryMap BlogSearchApiDto blogSearchApiDto);
}
