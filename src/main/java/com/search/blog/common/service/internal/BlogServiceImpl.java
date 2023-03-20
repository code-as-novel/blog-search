package com.search.blog.common.service.internal;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.search.blog.common.domain.dto.BlogSearchRequestDto;
import com.search.blog.common.domain.dto.BlogSearchResponseDto;
import com.search.blog.common.domain.entity.BlogSearchCount;
import com.search.blog.common.repository.BlogSearchCountRepository;
import com.search.blog.common.service.external.DaumApi;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BlogServiceImpl implements BlogService{
    final private DaumApi daumApi;
    final private BlogSearchCountRepository blogSearchCountRepository;

    @Override
    @Transactional
    public BlogSearchResponseDto search(final BlogSearchRequestDto blogSearchRequestDto){

        BlogSearchResponseDto result = daumApi.getDaumBlogSearch(blogSearchRequestDto);
        blogSearchCountRepository.findById(blogSearchRequestDto.getQuery())
                                 .ifPresentOrElse(searchCount -> searchCount.add(), 
                                 () -> blogSearchCountRepository.save(BlogSearchCount.of(blogSearchRequestDto.getQuery())));

        return result;
    }

    @Override
    public List<BlogSearchCount> getTopQuery(){
        return blogSearchCountRepository.findTop10ByOrderByCountDesc();
    }
}
