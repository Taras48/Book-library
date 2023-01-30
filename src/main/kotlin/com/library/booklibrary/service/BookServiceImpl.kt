package com.library.booklibrary.service

import com.library.booklibrary.dao.BookDao
import com.library.booklibrary.dto.BookDto
import com.library.booklibrary.extensions.bookDtoToBook
import com.library.booklibrary.extensions.bookToBookDto
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class BookServiceImpl(
    private val bookDao: BookDao,
) : BookService {


    override fun findBookById(id: Long) =
        bookDao.findBookById(id)?.bookToBookDto()

    override fun getAllBooks() =
        bookDao.getAllBooks()?.map { it.bookToBookDto() }

    @Transactional
    override fun saveBook(book: BookDto) =
        bookDao.saveBook(book.bookDtoToBook())
            .bookToBookDto()


    @Transactional
    override fun updateBookNameById(id: Long, name: String) {
        bookDao.findBookById(id)?.let {
            it.name = name
            bookDao.saveBook(it)
        }
    }

    @Transactional
    override fun deleteBookById(id: Long) {
        bookDao.findBookById(id)?.let {
            bookDao.deleteBookById(it)
        }
    }
}