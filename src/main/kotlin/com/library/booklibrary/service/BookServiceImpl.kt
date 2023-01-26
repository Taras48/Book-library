package com.library.booklibrary.service

import com.library.booklibrary.dao.BookDao
import com.library.booklibrary.dto.BookDto
import com.library.booklibrary.extensions.bookDtoToBook
import com.library.booklibrary.extensions.bookToBookDto
import com.library.booklibrary.model.Book
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class BookServiceImpl(
    private val bookDao: BookDao,
) : BookService {

    @Transactional
    override fun findBookById(id: Long) =
        bookDao.findBookById(id)?.bookToBookDto()

    @Transactional
    override fun getAllBooks() =
        bookDao.getAllBooks()?.map { it.bookToBookDto() }

    override fun deleteBookById(book: BookDto) =
        bookDao.deleteBookById(book.bookDtoToBook())

    override fun updateBookNameById(id: Long, name: String) =
        bookDao.updateBookNameById(id, name)

    override fun saveBook(book: BookDto) =
        bookDao.saveBook(book.bookDtoToBook())
            .bookToBookDto()
}