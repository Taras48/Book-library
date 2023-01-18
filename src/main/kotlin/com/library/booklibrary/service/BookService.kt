package com.library.booklibrary.service

import com.library.booklibrary.dto.BookDto
import com.library.booklibrary.model.Book

interface BookService {
    /**
     * Получение книги по id
     *
     * @param id  идентификатор книги
     * @return книга
     */
    fun findBookById(id: Long): BookDto?

    /**
     * Получение всех книг
     *
     * @return все книги
     */
    fun getAllBooks(): List<BookDto>?

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
    fun updateBook(book: BookDto): Int

    /**
     * Создание книги
     *
     * @param book  книга
     * @return книга
     */
    fun saveBook(book: BookDto): Book
}
