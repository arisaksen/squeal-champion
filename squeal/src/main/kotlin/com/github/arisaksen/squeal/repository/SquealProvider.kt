package com.github.arisaksen.squeal.repository

import com.github.arisaksen.squeal.dto.FilmDto
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface SquealProvider: CrudRepository<FilmDto, Long> {

    @Query("SELECT film_id, title, description FROM film ORDER BY film_id;")
    fun getAllFilms(): List<FilmDto>

    @Query("SELECT COUNT(*) FROM film;")
    fun countFilms(): Int

}
