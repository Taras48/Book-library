package com.library.booklibrary.service

import com.library.booklibrary.dto.AuthorDto

interface AuthorService {
    /**
     * Получение автора по id
     *
     * @param id  идентификатор автора
     * @return автор
     */
    fun findAuthorById(id: Long): AuthorDto?

    /**
     * Получение всех авторов
     *
     * @return все авторы
     */
    fun getAllAuthors(): List<AuthorDto>?

    /**
     * Удаление автора по id
     *
     * @param id  идентификатор автора
     *
     */
    fun deleteAuthorById(id: Long)

    /**
     * Обновление автора
     *
     * @param author  автора
     *
     */
    fun updateAuthorNameById(id: Long, name: String)

    /**
     * Создание автора
     *
     * @param author  автора
     * @return автора
     */
    fun saveAuthor(author: AuthorDto): AuthorDto
}