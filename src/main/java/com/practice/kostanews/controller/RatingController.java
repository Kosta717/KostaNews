package com.practice.kostanews.controller;

import com.practice.kostanews.dto.NewsDto;
import com.practice.kostanews.dto.RatingDto;
import com.practice.kostanews.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rate")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @PostMapping
    public void addRating(@RequestBody RatingDto ratingDto){ ratingService.ratingNews(ratingDto.getNewsId(), ratingDto.getUserId(), ratingDto.getRating()); }

    @GetMapping("/{id}")
    public RatingDto getRatingNews(@PathVariable Long id)
    {
        return ratingService.getRatingNew(id);
    }

    @GetMapping("filter/{id}")
    public List<NewsDto> getNewsByRating (@PathVariable Long id) { return ratingService.filterByRating(id); }

    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable Long id) { ratingService.deleteRating(id);}
}
