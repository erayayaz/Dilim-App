package com.example.Dilim.service.newsService;

import com.example.Dilim.dto.CreateNewsRequest;
import com.example.Dilim.dto.GetNewsDto;
import com.example.Dilim.dto.GetNewsRequest;
import com.example.Dilim.dto.NewsDto;

import java.util.List;

public interface NewsService {
    NewsDto createNews(CreateNewsRequest newsTrDto);

    void deleteNews(int id);

    NewsDto updateNews(int id, NewsDto newsTrDto);

    List<GetNewsDto> getAll(String language);

    List<GetNewsDto> getNewsByDate(GetNewsRequest request);
}
