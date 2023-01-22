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
     *
     */
    fun deleteGenreById(id: Long)

    /**
     * Обновление жанра
     *
     * @param genre  жанра
     *
     */
    fun updateGenreNameById(id: Long, name: String)

    /**
     * Создание жанра
     *
     * @param genre  жанра
     * @return автора
     */
    fun saveGenre(genre: GenreDto): GenreDto
}