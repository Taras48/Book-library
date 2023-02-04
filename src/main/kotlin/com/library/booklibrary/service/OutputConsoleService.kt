package com.library.booklibrary.service

import com.library.booklibrary.dto.AuthorDto
import com.library.booklibrary.dto.BookDto
import com.library.booklibrary.dto.CommentDto
import com.library.booklibrary.dto.GenreDto

interface OutputConsoleService {
    fun outputGenre(genre:GenreDto)
    fun outputComment(commen: CommentDto)
    fun outputBook(book: BookDto)
    fun outputAuthor(author: AuthorDto)
}