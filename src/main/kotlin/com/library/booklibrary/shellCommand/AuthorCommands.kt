package com.library.Authorlibrary.shellCommand

import com.library.booklibrary.dto.AuthorDto
import com.library.booklibrary.service.AuthorService
import com.library.booklibrary.service.OutputConsoleService
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod



@ShellComponent
class AuthorCommands(
    private val authorService: AuthorService,
    private val outputConsoleService: OutputConsoleService,
) {

//    @ShellMethod(key = ["db"])
//    fun getDb() {
//        Console.main()
//    }

    @ShellMethod(value = "Delete Author by Id", key = ["da", "delete"])
    fun deleteAuthorById(id: Long) {
        authorService.deleteAuthorById(id)
    }

    @ShellMethod(value = "Get all Authors", key = ["gaa", "get all"])
    fun getAllAuthors() {
        authorService.getAllAuthors()?.map { outputConsoleService.outputAuthor(it) }
    }

    @ShellMethod(value = "Get Author by id", key = ["ga", "get Author"])
    fun getAuthorById(id: Long) {
        authorService.findAuthorById(id)?.let { outputConsoleService.outputAuthor(it) }
    }

    @ShellMethod(value = "Save Author", key = ["sa", "save Author"])
    fun insertAuthor(name: String) {
        authorService.saveAuthor(AuthorDto(name = name))
            .let { outputConsoleService.outputAuthor(it) }
    }

    @ShellMethod(value = "Update Author", key = ["ua", "update Author"])
    fun updateAuthorNameById(id: Long, name: String) {
        authorService.updateAuthorNameById(id, name)
    }
}