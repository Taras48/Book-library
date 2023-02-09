package com.library.booklibrary.BookControllerTest

import com.fasterxml.jackson.databind.ObjectMapper
import com.library.booklibrary.controller.BookController
import com.library.booklibrary.dto.BookDto
import com.library.booklibrary.service.BookService
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.eq
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@WebMvcTest(BookController::class)
@ContextConfiguration(classes = [BookControllerTest.Environment::class])
class BookControllerTest(
    @Autowired private val bookService: BookService,
    @Autowired private val mvc: MockMvc,
    @Autowired private val objectMapper: ObjectMapper,
) {

    @Test
    @DisplayName("Получение всех книг")
    fun getAllBookTestOk() {
        val books = listOf(
            BookDto(name = "name1"),
            BookDto(name = "name1")
        )

        whenever(bookService.getAllBooks())
            .thenReturn(books)

        mvc
            .get("/books") {
                contentType = MediaType.APPLICATION_JSON
                accept = MediaType.APPLICATION_JSON
            }
            .andExpect {
                status { isOk() }
            }
    }

    @Test
    @DisplayName("Получение всех книг. Ошибка")
    fun getAllBookTestFail() {
        mvc
            .get("/booksss") {
                contentType = MediaType.APPLICATION_JSON
                accept = MediaType.APPLICATION_JSON
            }
            .andExpect {
                status { is4xxClientError() }
            }
    }

    @Test
    @DisplayName("Получение книги")
    fun getBookByIdTestOk() {
        val bookId = 1L
        val book = BookDto(id = bookId, name = "name1")

        whenever(bookService.findBookById(eq(bookId)))
            .thenReturn(book)

        mvc
            .get("/book?id=$bookId") {
                contentType = MediaType.APPLICATION_JSON
                accept = MediaType.APPLICATION_JSON
            }
            .andExpect {
                status { isOk() }
            }
    }

    @Test
    @DisplayName("Получение книги. Ошибка")
    fun getBookByIdTestFail() {
        mvc
            .get("/book") {
                contentType = MediaType.APPLICATION_JSON
                accept = MediaType.APPLICATION_JSON
            }
            .andExpect {
                status { is4xxClientError() }
            }
    }

    @Test
    @DisplayName("Получение сраницы обновления")
    fun getEditPageFormTestOk() {
        val bookId = 1L
        val book = BookDto(id = bookId, name = "name1")

        whenever(bookService.findBookById(eq(bookId)))
            .thenReturn(book)

        mvc
            .get("/edit?id=$bookId") {
                contentType = MediaType.APPLICATION_JSON
                accept = MediaType.APPLICATION_JSON
            }
            .andExpect {
                status { isOk() }
            }
    }

    @Test
    @DisplayName("Получение сраницы обновления. Ошибка")
    fun getEditPageFormTestFail() {
        mvc
            .get("/edit") {
                contentType = MediaType.APPLICATION_JSON
                accept = MediaType.APPLICATION_JSON
            }
            .andExpect {
                status { is4xxClientError() }
            }
    }

    @Test
    @DisplayName("Сохранение книги")
    fun saveBookTestOk() {
        val book = BookDto(name = "name1")

        whenever(bookService.saveBook(eq(book)))
            .thenReturn(book)

        mvc
            .post("/add/book") {
                contentType = MediaType.APPLICATION_JSON
                accept = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(book)
            }
            .andExpect {
                status { is3xxRedirection() }
            }
    }
    @Test
    @DisplayName("Сохранение книги. Ошибка")
    fun saveBookTestFail() {
        val book = BookDto(name = "name1")

        mvc
            .post("/add/books") {
                contentType = MediaType.APPLICATION_JSON
                accept = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(book)
            }
            .andExpect {
                status { is4xxClientError() }
            }
    }

    @Test
    @DisplayName("Получение сраницы сохранения")
    fun getSaveBookFormOk() {
        val book = BookDto(name = "name1")

        mvc
            .get("/add/books") {
                contentType = MediaType.APPLICATION_JSON
                accept = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(book)
            }
            .andExpect {
                status { is4xxClientError() }
            }
    }

    @TestConfiguration
    internal class Environment() {
        @Bean
        fun getBookService(): BookService = mock()
    }
}