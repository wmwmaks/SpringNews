package com.example.springexample.controllers;

import com.example.springexample.dto.NewsDto;
import com.example.springexample.services.NewsCRUDService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsCRUDService newsCRUDService;

    public NewsController(NewsCRUDService newsCRUDService) {
        this.newsCRUDService = newsCRUDService;
    }

    @GetMapping("/{id}")
    public NewsDto getNewsById(@PathVariable Long id) {
        return newsCRUDService.getById(id);
    }


    @GetMapping("/")
    public Collection<NewsDto> getAllNews() {
        return newsCRUDService.getAll();
    }

    @PostMapping("/")
    public void createNews(@RequestBody NewsDto newsDto) {
        newsCRUDService.create(newsDto);
    }

    @PutMapping("/{id}")
    public void updateNews(@PathVariable Long id, @RequestBody NewsDto newsDto) {
        newsDto.setId(id);
        newsCRUDService.update(newsDto);
    }

    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable Long id) {
        newsCRUDService.deleteById(id);
    }
}