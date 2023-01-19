package com.library.booklibrary.shellCommand

import com.library.booklibrary.dto.BookDto
import com.library.booklibrary.service.BookService
import com.library.booklibrary.service.OutputConsoleService
import org.h2.tools.Console
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod


@ShellComponent
class AppCommands(
    private val bookService: BookService,
    private val outputConsoleService: OutputConsoleService
) {

    @ShellMethod(key = ["db"])
    fun getDb() {
        Console.main()
    }

    @ShellMethod(value = "Delete Book by Id", key = ["d", "delete"])
    fun deleteBookById(id: Long) {
        bookService.deleteBookById(id)
    }

    @ShellMethod(value = "Get all Books", key = ["ga", "get all"])
    fun getAllBooks() {
         bookService.getAllBooks()?.map { outputConsoleService.outputBook(it) }
    }

    @ShellMethod(value = "Get book by id", key = ["gb", "get book"])
    fun getBookById(id: Long) {
         bookService.findBookById(id)?.let { outputConsoleService.outputBook(it) }
    }

    @ShellMethod(value = "Save book", key = ["s", "save book"])
    fun insertBook(name: String) {
        bookService.saveBook(BookDto(name = name))
            .let { outputConsoleService.outputBook(it) }
    }

    @ShellMethod(value = "Update book", key = ["u", "update book"])
    fun updateBook(id: Long, name: String) {
        bookService.updateBook(BookDto(id = id, name = name))
    }
}