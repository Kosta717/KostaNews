package com.practice.kostanews.entity;

import com.practice.kostanews.enums.TagsEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NewsEntity {
    private String title;
    private String description;
    private TagsEnum tags;
}
