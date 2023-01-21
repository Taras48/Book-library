package com.library.booklibrary.dto

import com.library.booklibrary.model.Genre

data class GenreDto(
    var id: Long? = null,
    val name: String,
    var books: MutableList<BookDto> = mutableListOf()
)

fun GenreDto.genreDtoToGenre() =
    Genre(
        this.id,
        this.name
    )
