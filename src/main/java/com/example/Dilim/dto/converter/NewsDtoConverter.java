package com.example.Dilim.dto.converter;

import com.example.Dilim.dto.NewsDto;
import com.example.Dilim.model.News;
import org.springframework.stereotype.Component;

@Component
public class NewsDtoConverter {
    public NewsDto convert (News from) {
        return new NewsDto(
                from.getId(),
                from.getTitleTr(),
                from.getTitleEng(),
                from.getSource(),
                from.getDescriptionTr(),
                from.getDescriptionEng(),
                from.getCreatedDate(),
                from.getUpdatedDate()
        );
    }
}
