package com.library.booklibrary.model

import com.library.booklibrary.dto.GenreDto

data class Genre(
    val id: Long,
    val name: String,
)


fun Genre.genreToGenreDto() =
    GenreDto(
        this.id,
        this.name
    )