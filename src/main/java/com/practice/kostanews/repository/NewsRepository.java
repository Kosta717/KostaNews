package com.practice.kostanews.repository;

import com.practice.kostanews.entity.NewsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<NewsEntity, Long> {
    List<NewsEntity> findAllByAuthor_Id(Long userId);

}
