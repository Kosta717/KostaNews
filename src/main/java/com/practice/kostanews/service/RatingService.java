package com.practice.kostanews.service;

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

@Service
public class RatingService {
    @Autowired
    RatingRepository ratingRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    NewsRepository newsRepository;

    @Transactional
    public void ratingNews(Long news_id, Long user_id, Integer rating)
    {
        if(1 < rating || rating > 5)
        {
            throw new CustomException("Рейтинг должен быть больше от 1 до 5!");
        }
        else {
            UserEntity user = userRepository.findById(user_id)
                    .orElseThrow(() -> new CustomException("Такого пользователя нету!"));
            NewsEntity news = newsRepository.findById(news_id)
                    .orElseThrow(() -> new CustomException("Такой новости нету!"));

            

        }

    }
}
