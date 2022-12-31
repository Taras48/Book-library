package com.library.booklibrary.dto

import com.library.booklibrary.model.Book

data class BookDto(
    var id: Long? = null,
    val name: String,
    val authors: MutableList<AuthorDto> = mutableListOf(),
    val gener: GenreDto? = null
)

fun BookDto.bookDtoToBook() =
    Book(
        this.id,
        this.name,
        this.authors.map { it.authorDtoToAuthor() }.toMutableList(),
        this.gener?.genreDtoToGenre(),
    )