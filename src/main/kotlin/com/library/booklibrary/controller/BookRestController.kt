package com.library.booklibrary.controller

import com.library.booklibrary.service.BookService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookRestController(
    private val bookService: BookService,
) {
    @PostMapping("/delete/book")
    fun deleteBook(@RequestBody id: String) =
        bookService.deleteBookById(id.toLong())
}