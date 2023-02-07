package com.library.booklibrary.controller

import com.library.booklibrary.dto.BookDto
import com.library.booklibrary.service.BookService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
class BookController(
    private val bookService: BookService
) {

    @GetMapping("/books")
    fun getAllBook(model: Model): String {
        model.addAttribute("books", bookService.getAllBooks())
        model["books"] = bookService.getAllBooks()!!
        return "books"
    }

    @GetMapping("/edit")
    fun editPage(@RequestParam("id") id: Long, model: Model): String? {
        val book = bookService.findBookById(id)
        model.addAttribute("book", book)
        return "edit"
    }

    @PostMapping("/save")
    fun getAllBook(@RequestParam("name") name: String, model: Model): String {
        bookService.saveBook(BookDto(name = name))
        return "books"
    }
}