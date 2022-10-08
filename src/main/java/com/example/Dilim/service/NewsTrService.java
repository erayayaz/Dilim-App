package com.example.Dilim.service;

import com.example.Dilim.dto.NewsTrDto;

import java.util.List;

public interface NewsTrService {
    NewsTrDto save(NewsTrDto newsTrDto);
    void delete(Long id);

    List<NewsTrDto> getAll();
}
