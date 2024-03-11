package com.github.arisaksen.squeal.service

import com.github.arisaksen.squeal.dto.FilmDto
import com.github.arisaksen.squeal.repository.SquealProvider
import org.springframework.stereotype.Service

@Service
class SquealService(
    private val squealProvider: SquealProvider
) {

    fun getHello(): List<FilmDto> {
        return squealProvider.getAllFilms()
    }

}