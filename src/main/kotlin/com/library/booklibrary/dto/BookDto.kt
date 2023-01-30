package com.library.booklibrary.dto

import com.library.booklibrary.model.Book

data class BookDto(
    var id: Long? = null,
    val name: String,
    val authors: MutableList<AuthorDto> = mutableListOf(),
    var gener: GenreDto? = null
)