package com.library.booklibrary.dao

import com.library.booklibrary.model.Genre

interface GenreDao {
    /**
     * Получение жанра по id
     *
     * @param id  идентификатор жанра
     * @return жанр
     */
    fun findGenreById(id: Long): Genre?

    /**
     * Получение всех жанров
     *
     * @return все жанры
     */
    fun getAllGenres(): List<Genre>?

    /**
     * Удаление жанра по id
     *
     * @param id  идентификатор жанра
     * @return  количество удаленных строк
     */
    fun deleteGenreById(id: Long): Int

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
    fun saveGenre(genre: Genre): Genre
}