package com.example.Dilim.dto

import javax.validation.constraints.NotBlank

data class NewsDto(
    val id: Int?,
    @field:NotBlank(message = "TitleTr must not be empty")
    val titleTr: String,
    @field:NotBlank(message = "TitleEng must not be empty")
    val titleEng: String,
    @field:NotBlank(message = "Source must not be empty")
    val source: String,
    @field:NotBlank(message = "DescriptionTr must not be empty")
    val descriptionTr: String,
    @field:NotBlank(message = "DescriptionEng must not be empty")
    val descriptionEng: String,
    val createdDate: String,
    val updatedDate: String?
) {
}
