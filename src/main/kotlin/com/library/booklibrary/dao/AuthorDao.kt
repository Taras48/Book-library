package com.library.Authorlibrary.dao

import com.library.booklibrary.model.Author

interface AuthorDao {

    /**
     * Получение автора по id
     *
     * @param id  идентификатор автора
     * @return автор
     */
    fun findAuthorById(id: Long): Author?

    /**
     * Получение всех авторов
     *
     * @return все авторы
     */
    fun getAllAuthors(): List<Author>?

    /**
     * Удаление автора по id
     *
     * @param id  идентификатор автора
     * @return  количество удаленных строк
     */
    fun deleteAuthorById(author: Author)

    /**
     * Создание автора
     *
     * @param author  автора
     * @return автора
     */
    fun saveAuthor(author: Author): Author
}