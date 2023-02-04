package com.library.booklibrary.dto

data class BookDto(
    var id: Long? = null,
    val name: String,
    val authors: MutableList<AuthorDto> = mutableListOf(),
    var gener: GenreDto? = null,
    var comments: MutableList<CommentDto> = mutableListOf(),
)