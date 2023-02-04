package com.library.booklibrary.extensions

import com.library.booklibrary.dto.*
import com.library.booklibrary.model.*


fun Book.bookToBookDto() =
    BookDto(
        this.id,
        this.name,
        this.authors.map { it.authorToAuthorDto() }.toMutableList(),
        this.comments.map { it.commentToCommentDto() }.toMutableList(),
        this.gener?.genreToGenreDto()
    )

fun BookDto.bookDtoToBook() =
    Book(
        this.id,
        this.name,
        this.comments.map { it.commentDtoToComment() }.toMutableList(),
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
        this.text,
    )

fun CommentDto.commentDtoToComment() =
    Comment(
        this.id,
        this.text,
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