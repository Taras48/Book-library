package com.library.booklibrary.dto

import com.library.booklibrary.model.Genre

data class GenreDto(
    val id: Long,
    val name: String,
    var books: MutableList<BookDto> = mutableListOf()
)

fun GenreDto.genreDtoToGenre() =
    Genre(
        this.id,
        this.name
    )
