package com.example.Dilim.dto.converter;

import com.example.Dilim.dto.NewsDto;
import com.example.Dilim.model.News;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class NewsDtoConverter {
    public NewsDto convert(News from) {
        return new NewsDto(
                from.getId(),
                from.getTitleTr(),
                from.getTitleEng(),
                from.getSource(),
                Objects.requireNonNull(from.getDescriptionTr()),
                Objects.requireNonNull(from.getDescriptionEng()),
                Objects.requireNonNull(from.getCreatedDate()),
                from.getUpdatedDate()
        );
    }
}
