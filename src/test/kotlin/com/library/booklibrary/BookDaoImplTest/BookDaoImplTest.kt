package com.library.booklibrary.BookDaoImplTest

import com.library.booklibrary.dao.BookDaoImpl
import com.library.booklibrary.model.Author
import com.library.booklibrary.model.Book
import com.library.booklibrary.model.Comment
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.context.annotation.Import
import kotlin.test.assertEquals

@DataJpaTest
@Import(BookDaoImpl::class)
class BookDaoImplTest() {

    @Autowired
    private lateinit var bookDao: BookDaoImpl

    @Autowired
    private lateinit var em: TestEntityManager
    @Test
    @DisplayName("Получение книги по id")
    fun findBookById() {
        val book = bookDao.findBookById(1)
        val expected = em.find(Book::class.java, 1L)

        assertEquals(expected, book)
    }

    @Test
    @DisplayName("Удаление книги по id")
    fun deleteBookById() {
        val book = em.find(Book::class.java, 1L)
        em.detach(book)

        val actual = bookDao.deleteBookById(1L)

        assertEquals(1, actual)
    }

    @Test
    @DisplayName("Создание книги")
    fun saveBook() {
        val book = bookDao.saveBook(Book(name = "test"))
        val expected = em.find(Book::class.java, 3L)

        assertEquals(expected, book)
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
                comments = mutableListOf(
                    Comment(1, "text1"),
                    Comment(3, "text3")
                )
            ),
            Book(
                id = 2,
                name = "book2",
                authors = mutableListOf(
                    Author(2, "author2"),
                    Author(1, "author1")
                ),
                comments = mutableListOf(
                    Comment(2, "text2")
                )
            )
        )

        assertEquals(expected, books)
    }

    @Test
    @DisplayName("Обновление книги")
    fun updateBook() {
        val book = Book(
            id = 2,
            name = "book3",
            authors = mutableListOf(
                Author(2, "author2"),
                Author(3, "author3")
            )
        )

        bookDao.updateBook(book)
        val books = bookDao.getAllBooks()

        val expected = listOf(
            Book(
                id = 1,
                name = "book1",
                authors = mutableListOf(Author(1, "author1"))
            ),
            Book(
                id = 2,
                name = "book3",
                authors = mutableListOf(
                    Author(2, "author2"),
                    Author(3, "author3")
                )
            )
        )

        assertEquals(expected, books)
    }

}