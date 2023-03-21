package com.search.blog.common.service.internal;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.search.blog.common.domain.dto.BlogSearchRequestDto;
import com.search.blog.common.domain.dto.BlogSearchResponseDto;
import com.search.blog.common.domain.entity.BlogRank;
import com.search.blog.common.repository.BlogRankRepository;
import com.search.blog.common.service.external.DaumApi;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BlogServiceImpl implements BlogService{
    final private DaumApi daumApi;
    final private BlogRankRepository blogSearchCountRepository;

    @Override
    @Transactional
    public BlogSearchResponseDto search(final BlogSearchRequestDto blogSearchRequestDto){
        BlogSearchResponseDto result = requestSearchApi(blogSearchRequestDto);
        addRank(blogSearchRequestDto);

        return result;
    }

    private BlogSearchResponseDto requestSearchApi(final BlogSearchRequestDto blogSearchRequestDto) {
        return daumApi.getDaumBlogSearch(blogSearchRequestDto);
    }

    private void addRank(final BlogSearchRequestDto blogSearchRequestDto){
        blogSearchCountRepository.findById(blogSearchRequestDto.getQuery())
                                 .ifPresentOrElse(searchCount -> searchCount.add(), 
                                   () -> blogSearchCountRepository.save(BlogRank.of(blogSearchRequestDto.getQuery())));
    }

    @Override
    @Transactional(readOnly = true)
    public List<BlogRank> getTopQuery(){
        return blogSearchCountRepository.findTop10ByOrderByCountDesc();
    }
}
