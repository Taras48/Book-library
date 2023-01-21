package com.library.Genrelibrary.shellCommand

import com.library.booklibrary.dto.GenreDto
import com.library.booklibrary.service.GenreService
import com.library.booklibrary.service.OutputConsoleService
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class GenreCommands(
    private val GenreService: GenreService,
    private val outputConsoleService: OutputConsoleService,
) {

    @ShellMethod(value = "Delete Genre by Id", key = ["dg", "delete"])
    fun deleteGenreById(id: Long) {
        GenreService.deleteGenreById(id)
    }

    @ShellMethod(value = "Get all Genres", key = ["gag", "get all"])
    fun getAllGenres() {
        GenreService.getAllGenres()?.map { outputConsoleService.outputGenre(it) }
    }

    @ShellMethod(value = "Get Genre by id", key = ["gg", "get Genre"])
    fun getGenreById(id: Long) {
        GenreService.findGenreById(id)?.let { outputConsoleService.outputGenre(it) }
    }

    @ShellMethod(value = "Save Genre", key = ["sg", "save Genre"])
    fun insertGenre(name: String) {
        GenreService.saveGenre(GenreDto(name = name))
            .let { outputConsoleService.outputGenre(it) }
    }

    @ShellMethod(value = "Update Genre", key = ["ug", "update Genre"])
    fun updateGenreNameById(id: Long, name: String) {
        GenreService.updateGenreNameById(id, name)
    }
}