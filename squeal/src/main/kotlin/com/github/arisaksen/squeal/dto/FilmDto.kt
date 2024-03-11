package com.github.arisaksen.squeal.dto

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id

data class FilmDto(
    @Id
    @JsonProperty("id")
    val film_id: Int,

    val title: String,
    val description: String
)
