package com.example.Dilim.dto

import javax.validation.constraints.NotBlank

data class GetNewsRequest(
    @field:NotBlank(message = "Language must not be empty")
    val language: String,
    @field:NotBlank(message = "Requested Date must not be empty")
    val requestedDate: String,
)
