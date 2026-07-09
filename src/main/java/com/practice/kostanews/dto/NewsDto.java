package com.practice.kostanews.dto;

import com.practice.kostanews.enums.TagsEnum;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Builder
public class NewsDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_news;
    private String title;
    private String description;
    private TagsEnum tags;
}
