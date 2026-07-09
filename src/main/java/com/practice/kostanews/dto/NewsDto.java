package com.practice.kostanews.dto;

import com.practice.kostanews.enums.TagsEnum;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {
    private Long id;
    private String title;
    private String description;
    private TagsEnum tags;
}
