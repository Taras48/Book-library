package com.library.booklibrary.service

import com.library.booklibrary.dto.GenreDto
import com.library.booklibrary.model.Genre

interface GenreService {
    /**
     * Получение жанра по id
     *
     * @param id  идентификатор жанра
     * @return жанр
     */
    fun findGenreById(id: Long): GenreDto?

    /**
     * Получение всех жанров
     *
     * @return все жанры
     */
    fun getAllGenres(): List<GenreDto>?

    /**
     * Удаление жанра по id
     *
     * @param id  идентификатор жанра
     * @return  количество удаленных строк
     */
    fun deleteGenreById(genre: GenreDto)

    /**
     * Обновление жанра
     *
     * @param genre  жанра
     * @return количество измененных строк
     */
    fun updateGenreNameById(id: Long, name: String): Int

    /**
     * Создание жанра
     *
     * @param genre  жанра
     * @return автора
     */
    fun saveGenre(genre: GenreDto): GenreDto
}