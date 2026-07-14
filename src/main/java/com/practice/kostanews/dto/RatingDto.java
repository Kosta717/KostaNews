package com.practice.kostanews.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {
    private Long id;
    private Long userId;
    private Long newsId;
    private int rating;
}
