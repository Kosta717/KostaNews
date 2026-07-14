package com.practice.kostanews.controller;

import com.practice.kostanews.dto.RatingDto;
import com.practice.kostanews.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rate")
public class RatingController {
    @Autowired
    RatingService ratingService;

    @PostMapping
    public void addRating(@RequestBody RatingDto ratingDto){ ratingService.ratingNews(ratingDto.getNewsId(), ratingDto.getUserId(), ratingDto.getRating()); }

    @GetMapping
    public RatingDto getRatingNews(Long id)
    {
        return ratingService.getRatingNew(id);
    }
}
