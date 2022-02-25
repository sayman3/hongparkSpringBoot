package com.example.hongparkSpringBoot.repository;

import com.example.hongparkSpringBoot.Entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    @Override
    ArrayList<Article> findAll();
}
