package com.practice.kostanews.service;

import com.practice.kostanews.dto.NewsDto;
import com.practice.kostanews.entity.NewsEntity;
import com.practice.kostanews.entity.UserEntity;
import com.practice.kostanews.exception.CustomException;
import com.practice.kostanews.repository.NewsRepository;
import com.practice.kostanews.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewsService {
    @Autowired
    NewsRepository newsRepository;
    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<NewsDto> getAllNews(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt"));
        Page<NewsEntity> newsPage = newsRepository.findAll(pageable);
        return newsPage
                .map(news_entity -> NewsDto.builder()
                        .id(news_entity.getId())
                        .title(news_entity.getTitle())
                        .createdAt(news_entity.getCreatedAt())
                        .description(news_entity.getDescription())
                        .tags(news_entity.getTags())
                        .userId(news_entity.getAuthor().getId())
                        .build()
                );
    }

    public NewsDto addNews(NewsDto newsDto){
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setTitle(newsDto.getTitle());
        newsEntity.setDescription(newsDto.getDescription());
        newsEntity.setTags(newsDto.getTags());
        UserEntity user = userRepository.findById(newsDto.getUserId())
                .orElseThrow(() -> new CustomException("Нету текущего id пользователя"));
        newsEntity.setAuthor(user);
        NewsEntity result = newsRepository.save(newsEntity);

        return NewsDto.builder()
                .id(result.getId())
                .title(result.getTitle())
                .createdAt(result.getCreatedAt())
                .description(result.getDescription())
                .tags(result.getTags())
                .userId(result.getAuthor().getId())
                .build();
    }

    @Transactional
    public void deleteNews(Long id) {
        NewsEntity entity = newsRepository.findById(id)
                .orElseThrow(() -> new CustomException("Нет такой новости!"));
        newsRepository.deleteById(entity.getId());
    }

    @Transactional
    public NewsDto updateNew(Long newsId, NewsDto newsDto)
    {
        NewsEntity newsEntity = newsRepository.findById(newsId)
                .orElseThrow(() -> new CustomException("Обновить не получится. Такой новости нет!"));
        newsEntity.setTitle(newsDto.getTitle());
        newsEntity.setDescription(newsDto.getDescription());
        newsEntity.setTags(newsDto.getTags());
        UserEntity user = userRepository.findById(newsDto.getUserId())
                .orElseThrow(() -> new CustomException("Нету текущего id пользователя"));
        newsEntity.setAuthor(user);

        NewsEntity saved = newsRepository.save(newsEntity);

        return NewsDto.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .description(saved.getDescription())
                .tags(saved.getTags())
                .userId(saved.getAuthor().getId())
                .build();
    }
}
