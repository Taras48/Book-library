package com.library.booklibrary.shellCommand

import com.library.booklibrary.service.BookService


//@ShellComponent
class AppCommands(
    private val bookService: BookService
) {
}