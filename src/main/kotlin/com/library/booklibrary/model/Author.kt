package com.library.booklibrary.model

import com.library.booklibrary.dto.AuthorDto

data class Author(
    val id: Long,
    val surName: String?,
)


fun Author.authorToAuthorDto() =
    AuthorDto(
        this.id,
        this.surName
    )