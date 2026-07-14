package com.practice.kostanews.dto;

import com.practice.kostanews.enums.TagsEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {
    private Long id;
    private String title;
    private LocalDateTime createdAt;
    private String description;
    private TagsEnum tags;
    private Long userId;
}
