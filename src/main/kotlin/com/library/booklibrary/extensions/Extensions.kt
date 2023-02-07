package com.library.booklibrary.extensions

import com.library.booklibrary.dto.AuthorDto
import com.library.booklibrary.dto.BookDto
import com.library.booklibrary.dto.CommentDto
import com.library.booklibrary.dto.GenreDto
import com.library.booklibrary.model.Author
import com.library.booklibrary.model.Book
import com.library.booklibrary.model.Comment
import com.library.booklibrary.model.Genre


fun Book.bookToBookDto() =
    BookDto(
        this.id,
        this.name,
        this.authors.map { it.authorToAuthorDto() }.toMutableList(),
        this.gener?.genreToGenreDto()
    )

fun BookDto.bookDtoToBook() =
    Book(
        this.id,
        this.name,
        this.authors.map { it.authorDtoToAuthor() }.toMutableList(),
        this.gener?.genreDtoToGenre()
    )

fun Author.authorToAuthorDto() =
    AuthorDto(
        this.id,
        this.name
    )

fun AuthorDto.authorDtoToAuthor() =
    Author(
        this.id,
        this.name
    )

fun Comment.commentToCommentDto() =
    CommentDto(
        this.id,
        this.text
    )

fun CommentDto.commentDtoToComment() =
    Comment(
        this.id,
        this.text
    )

fun Genre.genreToGenreDto() =
    GenreDto(
        this.id,
        this.name
    )

fun GenreDto.genreDtoToGenre() =
    Genre(
        this.id,
        this.name
    )