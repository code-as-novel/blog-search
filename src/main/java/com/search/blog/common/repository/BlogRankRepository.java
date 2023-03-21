package com.search.blog.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.search.blog.common.domain.entity.BlogRank;

public interface BlogRankRepository extends JpaRepository<BlogRank, String>{
    List<BlogRank> findTop10ByOrderByCountDesc();
}
