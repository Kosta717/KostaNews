package com.practice.kostanews.service;

import com.practice.kostanews.dto.NewsDto;
import com.practice.kostanews.dto.RatingDto;
import com.practice.kostanews.entity.NewsEntity;
import com.practice.kostanews.entity.RatingEntity;
import com.practice.kostanews.entity.UserEntity;
import com.practice.kostanews.exception.CustomException;
import com.practice.kostanews.repository.NewsRepository;
import com.practice.kostanews.repository.RatingRepository;
import com.practice.kostanews.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RatingService {
    @Autowired
    RatingRepository ratingRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    NewsRepository newsRepository;

    @Transactional
    public void ratingNews(Long news_id, Long user_id, Integer rating) {
        if (1 > rating || rating > 5) {
            throw new CustomException("Рейтинг должен быть больше от 1 до 5!");
        }
        UserEntity user = userRepository.findById(user_id)
                .orElseThrow(() -> new CustomException("Такого пользователя нету!"));
        NewsEntity news = newsRepository.findById(news_id)
                .orElseThrow(() -> new CustomException("Такой новости нету!"));

        RatingEntity check_rating = ratingRepository.findByAuthorAndNews(user, news);

        if(check_rating!=null)
        {
            check_rating.setRating(rating);
            ratingRepository.save(check_rating);
        }
        else
        {
            RatingEntity newRating = new RatingEntity();
            newRating.setAuthor(user);
            newRating.setNews(news);
            newRating.setRating(rating);
            ratingRepository.save(newRating);
        }
    }

    @Transactional(readOnly = true)
    public RatingDto getRatingNew(Long id) {
        return ratingRepository.findById(id).map(
                entity -> RatingDto.builder()
                        .id(entity.getId())
                        .newsId(entity.getNews().getId())
                        .userId(entity.getAuthor().getId())
                        .rating(entity.getRating())
                        .build()
        ).orElseThrow(() -> new CustomException("Такой оценки не существует!"));
    }

    @Transactional
    public void deleteRating(Long id)
    {
        RatingEntity ratingEntity = ratingRepository.findById(id)
                .orElseThrow(() -> new CustomException("Нету оценки такой"));
        ratingRepository.deleteById(ratingEntity.getId());
    }

    @Transactional(readOnly = true)
    public List<NewsDto> filterByRating(Long rating)
    {
        List<RatingEntity> newsByRating = ratingRepository.findByRating(rating);
        return newsByRating.stream()
                .map(entity -> NewsDto.builder()
                        .id(entity.getNews().getId())
                        .title(entity.getNews().getTitle())
                        .createdAt(entity.getNews().getCreatedAt())
                        .description(entity.getNews().getDescription())
                        .tags(entity.getNews().getTags())
                        .userId(entity.getAuthor().getId())
                        .build()
                ).toList();
    }
}