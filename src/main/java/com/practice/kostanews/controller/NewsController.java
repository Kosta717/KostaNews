package com.practice.kostanews.controller;

import com.practice.kostanews.dto.NewsDto;
import com.practice.kostanews.service.NewsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;

    @GetMapping
    public Page<NewsDto> getAllNew(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "2") int size
    ) {
        return newsService.getAllNews(page, size);
    }

    @PostMapping
    public NewsDto addNew(@Valid @RequestBody NewsDto newsDto) { return newsService.addNews(newsDto); }

    @DeleteMapping("/{id}")
    public void deleteNew(@PathVariable Long id) {
        newsService.deleteNews(id);
    }

    @PatchMapping("/{id}")
    public NewsDto updateNews(@PathVariable Long id, @RequestBody NewsDto newsDto) { return newsService.updateNew(id, newsDto); }

}
