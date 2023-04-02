package com.library.booklibrary.BookControllerTest

import com.fasterxml.jackson.databind.ObjectMapper
import com.library.booklibrary.controller.BookController
import com.library.booklibrary.dto.BookDto
import com.library.booklibrary.service.AuthorService
import com.library.booklibrary.service.BookService
import com.library.booklibrary.service.GenreService
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.eq
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.test.context.support.WithAnonymousUser
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@WebMvcTest(BookController::class)
@WithMockUser(username = "admin", authorities = ["admin"])
class BookControllerTest {
    @MockBean
    lateinit var bookService: BookService
    @MockBean
    lateinit var userDetailsService: UserDetailsService
    @MockBean
    lateinit var genreService: GenreService
    @MockBean
    lateinit var authorService: AuthorService
    @Autowired
    lateinit var mvc: MockMvc
    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    @DisplayName("Получение всех книг анонимом")
    @WithAnonymousUser
    fun getAllBookWithAnonymousTestFail() {
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
                status { is3xxRedirection() }
            }
    }

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
}