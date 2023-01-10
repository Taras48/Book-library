package com.library.booklibrary.model

import com.library.booklibrary.dto.BookDto
import com.library.booklibrary.dto.authorDtoToAuthor

data class Book(
    var id: Long? = null,
    val name: String,
    var authors: MutableList<Author> = mutableListOf(),
    var gener: Genre? = null
)

fun Book.bookToBookDto()=
    BookDto(
this.id,
this.name,
this.authors.map { it.authorToAuthorDto() }.toMutableList(),
this.gener?.genreToGenreDto(),
)


