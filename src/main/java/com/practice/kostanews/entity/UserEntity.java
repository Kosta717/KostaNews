package com.practice.kostanews.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String jobs;

    @OneToMany(mappedBy = "author")
    private List<NewsEntity> news;

    @OneToMany(mappedBy = "author")
    private List<RatingEntity> rating;

}
