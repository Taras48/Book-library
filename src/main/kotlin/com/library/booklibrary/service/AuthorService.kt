package com.library.booklibrary.service

import com.library.booklibrary.dto.AuthorDto
import com.library.booklibrary.model.Author

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
     * @return  количество удаленных строк
     */
    fun deleteAuthorById(author: AuthorDto)

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