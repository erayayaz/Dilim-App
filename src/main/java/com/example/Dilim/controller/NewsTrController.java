package com.example.Dilim.controller;

import com.example.Dilim.dto.NewsTrDto;
import com.example.Dilim.repository.NewsTrRepository;
import com.example.Dilim.service.NewsTrService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/news_trs")
@RequiredArgsConstructor
public class NewsTrController {

    private final NewsTrService newsTrService;

    @GetMapping
    public ResponseEntity<List<NewsTrDto>> getAll() {
        return ResponseEntity.ok(newsTrService.getAll());
    }

    @PostMapping
    public ResponseEntity<NewsTrDto> add(@RequestBody NewsTrDto newsTrDto) {
        return ResponseEntity.ok(newsTrService.save(newsTrDto));
    }

}
