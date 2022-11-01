package com.example.Dilim.service.newsTrService;

import com.example.Dilim.dto.NewsTrDto;
import com.example.Dilim.entity.NewsTr;
import com.example.Dilim.exception.NewsNotFoundException;
import com.example.Dilim.repository.NewsTrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@RequiredArgsConstructor
public class NewsTrServiceImpl implements NewsTrService{

    private final NewsTrRepository newsTrRepository;

    @Override
    public NewsTrDto save(NewsTrDto newsTrDto) {

        NewsTr newsTr = new NewsTr(newsTrDto.getId(), newsTrDto.getTitle(), newsTrDto.getSource(),
                newsTrDto.getDescription(), getDate());

        final NewsTr newsTrDb = newsTrRepository.save(newsTr);
        newsTrDto.setId(newsTrDb.getId());

        return newsTrDto;
    }

    @Override
    public void delete(Long id) {

        Optional<NewsTr> newsTr = Optional.ofNullable(findCustomerById(id));
        newsTrRepository.deleteById(Objects.requireNonNull(newsTr.get().getId()));
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

    private String getDate () {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }

    private NewsTr findCustomerById(Long id) {
        return newsTrRepository.findById(id)
                .orElseThrow(
                    () -> new NewsNotFoundException("NewsTr could not find by id: " + id));

    }
}
