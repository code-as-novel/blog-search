package com.search.blog.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.search.blog.common.domain.entity.BlogSearchCount;

public interface BlogSearchCountRepository extends JpaRepository<BlogSearchCount, String>{
    
}