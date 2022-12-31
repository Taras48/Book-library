package com.library.booklibrary.dto

import com.library.booklibrary.model.Author

data class AuthorDto(
    val id: Long,
    val surName: String,
)

fun AuthorDto.authorDtoToAuthor() =
    Author(
        this.id,
        this.surName
    )