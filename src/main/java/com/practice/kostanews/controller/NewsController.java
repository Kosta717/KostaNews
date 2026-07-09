package com.practice.kostanews.controller;

import com.practice.kostanews.dto.NewsDto;
import com.practice.kostanews.entity.NewsEntity;
import com.practice.kostanews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsService newsService;

    @GetMapping
    public List<NewsDto> getAllNew(){ return newsService.getAllNews();}

    @PostMapping
    public NewsDto addNew(@RequestBody NewsDto newsDto) { return newsService.addNews(newsDto); }

    @DeleteMapping("/{id}")
    public void deleteNew(@PathVariable Long id) {
        newsService.deleteNews(id);
    }
}
