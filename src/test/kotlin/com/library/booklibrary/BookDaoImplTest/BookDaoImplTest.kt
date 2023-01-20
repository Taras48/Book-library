package com.library.booklibrary.BookDaoImplTest

import com.library.booklibrary.dao.BookDaoImpl
import com.library.booklibrary.model.Author
import com.library.booklibrary.model.Book
import org.assertj.core.api.Assertions.assertThat
import org.hibernate.SessionFactory
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.context.annotation.Import
import kotlin.test.assertEquals
import kotlin.test.assertNull

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
        val deletedBook = em.find(Book::class.java, 1L)

        assertNull(deletedBook)
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
        val sessionFactory = em.entityManager.entityManagerFactory.unwrap(SessionFactory::class.java)
        sessionFactory.statistics.isStatisticsEnabled = true

        val books = bookDao.getAllBooks()

        assertThat(books).isNotNull()
            .hasSize(2)
            .allMatch { s -> s.name != "" }
            .allMatch { s -> s.authors.size > 0 }
            .allMatch { s -> s.comments.size > 0 }

        assertThat(sessionFactory.statistics.prepareStatementCount).isEqualTo(3)
    }

    @Test
    @DisplayName("Обновление книги")
    fun updateBookNameById() {
        val actual = bookDao.updateBookNameById(2, "book3")
        val actualBook = bookDao.findBookById(2)

        assertEquals("book3", actualBook.name)
        assertEquals(1, actual)
    }

}