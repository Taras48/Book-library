package com.library.booklibrary

import org.h2.tools.Console
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookLibraryApplication

fun main(args: Array<String>) {
    runApplication<BookLibraryApplication>(*args)
    Console.main(*args)
}
