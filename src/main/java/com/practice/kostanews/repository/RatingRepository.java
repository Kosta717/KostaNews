package com.practice.kostanews.repository;

import com.practice.kostanews.entity.NewsEntity;
import com.practice.kostanews.entity.RatingEntity;
import com.practice.kostanews.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<RatingEntity, Long> {

    RatingEntity findByAuthorAndNews(UserEntity author, NewsEntity news);
}
