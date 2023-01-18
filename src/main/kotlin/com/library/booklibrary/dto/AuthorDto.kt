package com.library.booklibrary.dto

import com.library.booklibrary.model.Author

data class AuthorDto(
    val id: Long,
    val name: String?
)

fun AuthorDto.authorDtoToAuthor() =
    Author(
        this.id,
        this.name
    )