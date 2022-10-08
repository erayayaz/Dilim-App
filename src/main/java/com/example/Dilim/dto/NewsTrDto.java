package com.example.Dilim.dto;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class NewsTrDto {

    private Long id;
    private String title;
    private String source;
    private String description;
    private String createdDate;
}