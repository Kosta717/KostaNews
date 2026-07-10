package com.practice.kostanews.entity;

import com.practice.kostanews.enums.TagsEnum;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @NonNull
    private TagsEnum tags;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity author;
}
