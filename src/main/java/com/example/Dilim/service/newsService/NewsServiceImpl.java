package com.example.Dilim.service.newsService;

import com.example.Dilim.dto.CreateNewsRequest;
import com.example.Dilim.dto.GetNewsDto;
import com.example.Dilim.dto.GetNewsRequest;
import com.example.Dilim.dto.NewsDto;
import com.example.Dilim.dto.converter.NewsDtoConverter;
import com.example.Dilim.enums.Language;
import com.example.Dilim.exception.NewsNotFoundException;
import com.example.Dilim.exception.NewsWithSameTitleException;
import com.example.Dilim.model.News;
import com.example.Dilim.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(NewsServiceImpl.class));
    private final NewsRepository newsRepository;
    private final NewsDtoConverter newsDtoConverter;

    @Override
    @Transactional
    public NewsDto createNews(final CreateNewsRequest request) {

        News news = newsRepository.findByTitleTrAndTitleEng(request.getTitleTr(), request.getTitleEng());
        if (news != null) {
            LOGGER.info("Duplicated title error occurred");
            throw new NewsWithSameTitleException("Duplicated title error occurred");
        }

        News insertedNews = new News(0, request.getTitleTr(), request.getTitleEng(), request.getSource(), request.getDescriptionTr(),
                request.getDescriptionEng(), request.getCreatedDate() == null ? getDate() : request.getCreatedDate(), null);
        return newsDtoConverter.convert(newsRepository.save(insertedNews));
    }

    @Override
    @Transactional
    public void deleteNews(final int id) {
        News news = findCustomerById(id);
        newsRepository.deleteById(Objects.requireNonNull(news.getId()));
    }

    @Override
    @Transactional
    public NewsDto updateNews(final int id, final NewsDto newsTrDto) {

        News news = findCustomerById(id);
        News updatedNews = new News(
                news.getId(),
                newsTrDto.getTitleTr(),
                newsTrDto.getTitleEng(),
                newsTrDto.getSource(),
                newsTrDto.getDescriptionTr(),
                newsTrDto.getDescriptionEng(),
                news.getCreatedDate(),
                getDate()
        );

        return newsDtoConverter.convert(newsRepository.save(updatedNews));
    }

    @Override
    public List<GetNewsDto> getAll(final String language) {
        List<News> newsList = newsRepository.findAll();

        if (newsList.size() == 0) {
            return new ArrayList<>();
        }

        return getNewsDtos(newsList, language);
    }

    @Override
    public List<GetNewsDto> getNewsByDate(final GetNewsRequest request) {
        List<News> newsList = newsRepository.findByDate(request.getRequestedDate());

        if (newsList.size() == 0) {
            return new ArrayList<>();
        }

        return getNewsDtos(newsList, request.getLanguage().toLowerCase());
    }

    private String getDate() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return dateFormat.format(date);
    }

    private News findCustomerById(int id) {
        return newsRepository.findById(id)
                .orElseThrow(() -> new NewsNotFoundException("NewsTr could not find by id: " + id));
    }

    private List<GetNewsDto> getNewsDtos(List<News> newsList, String language) {
        List<GetNewsDto> newsDtos = new ArrayList<>();

        if (language.equals(Language.TR.name().toLowerCase())) {
            newsList.forEach(news -> {
                GetNewsDto newsDto = new GetNewsDto(
                        news.getId(),
                        news.getTitleTr(),
                        news.getSource(),
                        Objects.requireNonNull(news.getDescriptionTr()),
                        Objects.requireNonNull(news.getCreatedDate()),
                        news.getUpdatedDate());

                newsDtos.add(newsDto);
            });
        } else if (language.equals(Language.EN.name().toLowerCase())) {
            newsList.forEach(news -> {
                GetNewsDto newsDto = new GetNewsDto(
                        news.getId(),
                        news.getTitleEng(),
                        news.getSource(),
                        Objects.requireNonNull(news.getDescriptionEng()),
                        Objects.requireNonNull(news.getCreatedDate()),
                        news.getUpdatedDate());

                newsDtos.add(newsDto);
            });
        }

        return newsDtos;
    }
}
