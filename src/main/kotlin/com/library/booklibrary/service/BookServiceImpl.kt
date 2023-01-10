package com.library.booklibrary.service

import com.library.booklibrary.dao.BookDao
import com.library.booklibrary.dto.BookDto
import com.library.booklibrary.dto.bookDtoToBook
import com.library.booklibrary.model.bookToBookDto
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(
    val bookDao: BookDao
):BookService {
    override fun findBookById(id: Long) =
        bookDao.findBookById(id)?.bookToBookDto()

    override fun getAllBooks()=
        bookDao.getAllBooks()?.map { it.bookToBookDto() }

    override fun deleteBookById(id: Long) =
        bookDao.deleteBookById(id)

    override fun updateBook(book: BookDto)=
        bookDao.updateBook(book.bookDtoToBook())

    override fun insertBook(book: BookDto) =
        bookDao.insertBook(book.bookDtoToBook())
}