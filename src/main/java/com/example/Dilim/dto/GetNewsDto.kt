package com.example.Dilim.dto

import javax.validation.constraints.NotBlank

data class GetNewsDto(
    val id: Int?,
    @field:NotBlank(message = "Title must not be empty")
    val title: String,
    @field:NotBlank(message = "Source must not be empty")
    val source: String,
    @field:NotBlank(message = "Description must not be empty")
    val description: String,
    val createdDate: String,
    val updatedDate: String?
)
