package com.library.booklibrary.dto

import com.library.booklibrary.model.Book

data class BookDto(
    var id: Long? = null,
    val name: String,
    val authors: MutableList<AuthorDto> = mutableListOf(),
    val comments: MutableList<CommentDto> = mutableListOf(),
)

fun BookDto.bookDtoToBook() =
    Book(
        this.id,
        this.name,
        this.comments.map { it.commentDtoToComment() }.toMutableList(),
        this.authors.map { it.authorDtoToAuthor() }.toMutableList()
    )