package com.example.Dilim.controller;

import com.example.Dilim.dto.NewsTrDto;
import com.example.Dilim.service.newsTrService.NewsTrService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/news_trs")
@RequiredArgsConstructor
public class NewsTrController {

    private final NewsTrService newsTrService;

    @GetMapping(value = "/news")
    public ResponseEntity<List<NewsTrDto>> getAll() {
        return ResponseEntity.ok(newsTrService.getAll());
    }

    @PostMapping
    public ResponseEntity<NewsTrDto> add(@RequestBody NewsTrDto newsTrDto) {
        return ResponseEntity.ok(newsTrService.save(newsTrDto));
    }

    @PutMapping
    public ResponseEntity<NewsTrDto> update(@RequestBody NewsTrDto newsTrDto) {
        return ResponseEntity.ok(newsTrService.update(newsTrDto));
    }

    @DeleteMapping(value = "/news/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {

        if (!newsTrService.delete(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
