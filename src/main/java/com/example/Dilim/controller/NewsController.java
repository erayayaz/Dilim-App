package com.example.Dilim.controller;

import com.example.Dilim.dto.CreateNewsRequest;
import com.example.Dilim.dto.GetNewsDto;
import com.example.Dilim.dto.GetNewsRequest;
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
        return ResponseEntity.status(HttpStatus.OK).body(newsService.getAll(language.toLowerCase()));
    }

    @GetMapping(value = "/getNewsByDate")
    public ResponseEntity<List<GetNewsDto>> getNewsByDate(@Valid @RequestBody GetNewsRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(newsService.getNewsByDate(request));
    }

    @PostMapping
    public ResponseEntity<NewsDto> createNews(@Valid @RequestBody CreateNewsRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(newsService.createNews(request));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<NewsDto> update(@PathVariable int id, @Valid @RequestBody NewsDto newsTrDto) {
        return ResponseEntity.status(HttpStatus.OK).body(newsService.updateNews(id, newsTrDto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        newsService.deleteNews(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}