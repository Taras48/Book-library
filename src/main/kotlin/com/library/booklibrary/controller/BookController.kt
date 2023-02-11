package com.library.booklibrary.controller

import com.library.booklibrary.dto.BookDto
import com.library.booklibrary.service.AuthorService
import com.library.booklibrary.service.BookService
import com.library.booklibrary.service.GenreService
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam


@Controller
class BookController(
    private val bookService: BookService,
    private val genreService: GenreService,
    private val authorService: AuthorService,
) {

    @GetMapping("/books")
    fun getAllBook(model: Model): String {
        model.addAttribute("books", bookService.getAllBooks())
        model["books"] = bookService.getAllBooks() ?: throw NotFoundException()
        return "books"
    }

    @GetMapping("/book")
    fun getBookById(@RequestParam("id") id: Long, model: Model): String? {
        val book = bookService.findBookById(id) ?: throw NotFoundException()
        model.addAttribute("book", book)
        return "book"
    }

    @GetMapping("/edit")
    fun getEditPageForm(@RequestParam("id") id: Long, model: Model): String? {
        val book = bookService.findBookById(id) ?: throw NotFoundException()
        val genres = genreService.getAllGenres()
        val authors = authorService.getAllAuthors()

        model.addAttribute("book", book)
        model.addAttribute("genres", genres)
        model.addAttribute("authors", authors)
        return "edit"
    }

    @PostMapping("/add/book")
    fun saveBook( book: BookDto, model: Model): String {
        bookService.saveBook(book)
        return "redirect:/books"
    }

    @GetMapping("/add/book")
    fun getSaveBookForm(model: Model): String? {
        val genres = genreService.getAllGenres()
        val authors = authorService.getAllAuthors()

        model.addAttribute("genres", genres)
        model.addAttribute("authors", authors)
        return "edit"
    }

    @GetMapping("/delete/book")
    fun getDeleteBookForm(@RequestParam("id") id: Long, model: Model): String? {
        val book = bookService.findBookById(id)
        model.addAttribute("book", book)
        return "delete"
    }

    @PostMapping("/delete/book")
    fun deleteBook(book: BookDto, model: Model): String {
        bookService.deleteBookById(book.id!!)
        return "redirect:/books"
    }
}