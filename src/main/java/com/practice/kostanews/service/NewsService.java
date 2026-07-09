package com.practice.kostanews.service;

import com.practice.kostanews.dto.NewsDto;
import com.practice.kostanews.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    NewsRepository newsRepository;

    public List<NewsDto> getAllNews(){
        return newsRepository.findAll().stream()
                .map(news_entity -> NewsDto.builder()
                        .title(news_entity.getTitle())
                        .description(news_entity.getDescription())
                        .tags(news_entity.getTags())
                        .build()
                ).toList();
    }
}
