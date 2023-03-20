package com.search.blog.common.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlogSearchCount {
    @Id
    private String query;
    
    @Setter
    private int count;

    public static BlogSearchCount of(String query){
        return new BlogSearchCount(query, 1);
    }

    public void add(){
        this.count++;
    }
}
