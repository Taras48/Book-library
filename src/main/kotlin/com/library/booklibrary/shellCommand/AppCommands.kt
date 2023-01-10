package com.library.booklibrary.shellCommand

import com.library.booklibrary.dto.BookDto
import com.library.booklibrary.service.BookService
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod


@ShellComponent
class AppCommands(
    private val bookService: BookService,
) {

    @ShellMethod(value = "Delete Book by Id", key = ["d", "delete"])
    fun deleteBookById(id: Long) {
        bookService.deleteBookById(id)
    }

    @ShellMethod(value = "Get all Books", key = ["ga", "get all"])
    fun getAllBooks(): List<BookDto>? {
        return bookService.getAllBooks()
    }

    @ShellMethod(value = "Get book by id", key = ["gb", "get book"])
    fun getBookById(id: Long): BookDto? {
        return bookService.findBookById(id)
    }

    @ShellMethod(value = "Insert book", key = ["i", "insert book"])
    fun insertBook(name: String) {
        bookService.insertBook(BookDto(name = name))
            .let { println("Добавлена книга с id = $it") }
    }

    @ShellMethod(value = "Update book", key = ["u", "update book"])
    fun updateBook(id: Long, name: String) {
        bookService.updateBook(BookDto(id = id, name = name))
    }
}