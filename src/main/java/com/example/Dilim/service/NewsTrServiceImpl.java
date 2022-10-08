package com.example.Dilim.service;

import com.example.Dilim.dto.NewsTrDto;
import com.example.Dilim.entity.NewsTr;
import com.example.Dilim.repository.NewsTrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsTrServiceImpl implements NewsTrService{

    private final NewsTrRepository newsTrRepository;

    @Override
    public NewsTrDto save(NewsTrDto newsTrDto) {

        NewsTr newsTr = NewsTr.builder()
                .id(newsTrDto.getId())
                .title(newsTrDto.getTitle())
                .source(newsTrDto.getSource())
                .description(newsTrDto.getDescription())
                .createdDate(newsTrDto.getCreatedDate())
                .build();

        final NewsTr newsTrDb = newsTrRepository.save(newsTr);
        newsTrDto.setId(newsTrDb.getId());

        return newsTrDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<NewsTrDto> getAll() {
        List<NewsTr> newsTrList = newsTrRepository.findAll();
        List<NewsTrDto> newsTrDtos = new ArrayList<>();

        newsTrList.forEach(it -> {
            NewsTrDto newsTrDto =  NewsTrDto.builder()
                    .id(it.getId())
                    .title(it.getTitle())
                    .source(it.getSource())
                    .description(it.getDescription())
                    .createdDate(it.getCreatedDate())
                    .build();

            newsTrDtos.add(newsTrDto);
        });

        return newsTrDtos;
    }
}
