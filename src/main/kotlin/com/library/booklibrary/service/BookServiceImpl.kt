package com.library.booklibrary.service

import com.library.booklibrary.dao.BookDao
import com.library.booklibrary.dto.BookDto
import com.library.booklibrary.dto.bookDtoToBook
import com.library.booklibrary.model.bookToBookDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class BookServiceImpl(
    private val bookDao: BookDao,
) : BookService {
    override fun findBookById(id: Long) =
        bookDao.findBookById(id)?.bookToBookDto()

    override fun getAllBooks() =
        bookDao.getAllBooks()?.map { it.bookToBookDto() }

    override fun deleteBookById(id: Long) =
        bookDao.deleteBookById(id)

    override fun updateBookNameById(id: Long, name: String) =
        bookDao.updateBookNameById(id, name)

    override fun saveBook(book: BookDto) =
        bookDao.saveBook(book.bookDtoToBook())
            .bookToBookDto()
}