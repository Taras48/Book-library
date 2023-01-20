package com.library.booklibrary.service

import com.library.booklibrary.dto.AuthorDto
import com.library.booklibrary.dto.BookDto
import com.library.booklibrary.dto.CommentDto
import com.library.booklibrary.dto.GenreDto
import org.springframework.stereotype.Service

@Service
class OutputConsoleServiceImpl : OutputConsoleService{
    override fun outputGenre(genre: GenreDto) =
        println("""
            Genre Name: $genre.name
            Genre books names: ${genre.books.map { it.id to it.name }}
        """.trimIndent())

    override fun outputComment(commen: CommentDto) =
        println("""
            Comment text: ${commen.text}
        """.trimIndent())

    override fun outputBook(book: BookDto) =
        println("""
            Book Name: ${book.name}
            Book authors: ${book.authors.map { it.id to it.name }}
            Book comments: ${book.comments.map { it.id to it.text }}
        """.trimIndent())

    override fun outputAuthor(author: AuthorDto)=
        println("""
            Author Name: $author.name
        """.trimIndent())
}