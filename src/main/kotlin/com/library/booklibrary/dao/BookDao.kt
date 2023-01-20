package com.library.booklibrary.dao

import com.library.booklibrary.model.Book

interface BookDao {

    /**
     * Получение книги по id
     *
     * @param id  идентификатор книги
     * @return книга
     */
    fun findBookById(id: Long): Book?

    /**
     * Получение всех книг
     *
     * @return все книги
     */
    fun getAllBooks(): List<Book>?

    /**
     * Удаление книги по id
     *
     * @param id  идентификатор книги
     * @return  количество удаленных строк
     */
    fun deleteBookById(id: Long): Int

    /**
     * Обновление книги
     *
     * @param book  книга
     * @return количество измененных строк
     */
    fun updateBookNameById(id: Long, name: String): Int

    /**
     * Создание книги
     *
     * @param book  книга
     * @return книга
     */
    fun saveBook(book: Book): Book
}