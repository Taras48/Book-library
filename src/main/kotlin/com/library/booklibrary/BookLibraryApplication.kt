package com.library.booklibrary

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.h2.tools.Console

@SpringBootApplication
class BookLibraryApplication

fun main(args: Array<String>) {
    runApplication<BookLibraryApplication>(*args)
    Console.main(*args)
}
