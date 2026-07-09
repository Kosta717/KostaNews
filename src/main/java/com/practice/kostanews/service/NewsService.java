package com.practice.kostanews.service;

import com.practice.kostanews.dto.NewsDto;
import com.practice.kostanews.dto.UserDto;
import com.practice.kostanews.entity.NewsEntity;
import com.practice.kostanews.entity.UserEntity;
import com.practice.kostanews.exception.CustomException;
import com.practice.kostanews.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public NewsDto addUser(NewsDto newsDto){
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setTitle(newsDto.getTitle());
        newsEntity.setDescription(newsDto.getDescription());
        newsEntity.setTags(newsDto.getTags());

        NewsEntity result = newsRepository.save(newsEntity);

        return NewsDto.builder()
                .title(result.getTitle())
                .description(result.getDescription())
                .tags(result.getTags())
                .build();
    }

    @Transactional
    public void deleteNews(Long id) {
        NewsEntity entity = newsRepository.findById(id)
                .orElseThrow(() -> new CustomException("Нет такой задачи!"));
        newsRepository.deleteById(entity.getId());
    }
}
