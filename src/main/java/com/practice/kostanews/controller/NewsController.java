package com.practice.kostanews.controller;

import com.practice.kostanews.dto.NewsDto;
import com.practice.kostanews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsService newsService;

    @GetMapping
    private List<NewsDto> getAllNew(){ return newsService.getAllNews();}
}
