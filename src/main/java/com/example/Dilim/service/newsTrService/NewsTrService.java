package com.example.Dilim.service.newsTrService;

import com.example.Dilim.dto.NewsTrDto;

import java.util.List;

public interface NewsTrService {
    NewsTrDto save(NewsTrDto newsTrDto);
    boolean delete(Long id);
    NewsTrDto update(NewsTrDto newsTrDto);

    List<NewsTrDto> getAll();
}
