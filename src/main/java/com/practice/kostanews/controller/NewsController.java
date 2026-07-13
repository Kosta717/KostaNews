package com.practice.kostanews.controller;

import com.practice.kostanews.dto.NewsDto;
import com.practice.kostanews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsService newsService;

    @GetMapping
    public Page<NewsDto> getAllNew(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "2") int size) {
        return newsService.getAllNews(page,size);
    }

    @PostMapping
    public NewsDto addNew(@RequestBody NewsDto newsDto) { return newsService.addNews(newsDto); }

    @DeleteMapping("/{id}")
    public void deleteNew(@PathVariable Long id) {
        newsService.deleteNews(id);
    }

    @PatchMapping("/{id}")
    public NewsDto updateNews(@PathVariable Long id, @RequestBody NewsDto newsDto) { return newsService.updateNew(id, newsDto); }

}
