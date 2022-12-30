package com.example.Dilim.controller;

import com.example.Dilim.dto.CreateNewsRequest;
import com.example.Dilim.dto.GetNewsDto;
import com.example.Dilim.dto.NewsDto;
import com.example.Dilim.service.newsService.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping(value = "/{language}")
    public ResponseEntity<List<GetNewsDto>> getAll(@PathVariable String language) {
        return ResponseEntity.ok(newsService.getAll(language.toLowerCase()));
    }

    @PostMapping
    public ResponseEntity<NewsDto> createNews(@Valid @RequestBody CreateNewsRequest request) {
        return ResponseEntity.ok(newsService.createNews(request));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<NewsDto> update(@PathVariable int  id, @Valid @RequestBody NewsDto newsTrDto) {
        return ResponseEntity.ok(newsService.update(id, newsTrDto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable int  id) {
        newsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}