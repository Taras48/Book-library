package com.library.booklibrary.BookDaoImplTest

import com.library.booklibrary.dao.BookDaoImpl
import com.library.booklibrary.model.Author
import com.library.booklibrary.model.Book
import com.library.booklibrary.model.Genre
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.context.annotation.Import
import kotlin.test.assertEquals

@JdbcTest
@Import(BookDaoImpl::class)
class BookDaoImplTest(
    @Autowired private val bookDao: BookDaoImpl,
) {

    @Test
    @DisplayName("Получение книги по id")
    fun findBookById() {
        val book = bookDao.findBookById(1)

        val expected = Book(
            id = 1,
            name = "book1",
            authors = mutableListOf(Author(1, "author1")),
            gener = Genre(1, "gener1")
        )

        assertEquals(expected, book)
    }

    @Test
    @DisplayName("Удаление книги по id")
    fun deleteBookById() {
        bookDao.deleteBookById(1)
        val books = bookDao.getAllBooks()

        val expected = listOf(
            Book(
                id = 2,
                name = "book2",
                authors = mutableListOf(
                    Author(2, "author2"),
                    Author(3, "author3")
                ),
                gener = Genre(2, "gener2")
            )
        )

        assertEquals(expected, books)
    }

    @Test
    @DisplayName("Создание книги")
    fun insertBook() {
        val book = Book(name = "test")
        val bookId = bookDao.insertBook(book)

        assertEquals(3, bookId)
    }

    @Test
    @DisplayName("Получение всех книг")
    fun getAllBooks() {
        val books = bookDao.getAllBooks()

        val expected = listOf(
            Book(
                id = 1,
                name = "book1",
                authors = mutableListOf(Author(1, "author1")),
                gener = Genre(1, "gener1")
            ),
            Book(
                id = 2,
                name = "book2",
                authors = mutableListOf(
                    Author(2, "author2"),
                    Author(3, "author3")
                ),
                gener = Genre(2, "gener2")
            )
        )

        assertEquals(expected, books)
    }

    @Test
    @DisplayName("Создание книги")
    fun updateBook() {
        val book = Book(
            id = 2,
            name = "book3",
            authors = mutableListOf(
                Author(2, "author2"),
                Author(3, "author3")
            ),
            gener = Genre(2, "gener2")
        )

        bookDao.updateBook(book)
        val books = bookDao.getAllBooks()

        val expected = listOf(
            Book(
                id = 1,
                name = "book1",
                authors = mutableListOf(Author(1, "author1")),
                gener = Genre(1, "gener1")
            ),
            Book(
                id = 2,
                name = "book3",
                authors = mutableListOf(
                    Author(2, "author2"),
                    Author(3, "author3")
                ),
                gener = Genre(2, "gener2")
            )
        )

        assertEquals(expected, books)
    }

}