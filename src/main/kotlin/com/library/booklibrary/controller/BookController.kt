package com.library.booklibrary.controller

import com.library.booklibrary.service.BookService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping


@Controller
class BookController(
    private val bookService: BookService,
) {

    @GetMapping("/books")
    fun getAllBook(model: Model): String {
        model.addAttribute("books", bookService.getAllBooks())
        model["books"] = bookService.getAllBooks()!!
        return "books"
    }

}