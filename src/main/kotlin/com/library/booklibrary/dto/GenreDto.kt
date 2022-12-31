package com.library.booklibrary.dto

import com.library.booklibrary.model.Genre

data class GenreDto(
    val id: Long,
    val name: String
)

fun GenreDto.genreDtoToGenre() =
    Genre(
        this.id,
        this.name
    )
