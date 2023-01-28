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
    @Transactional
    override fun findBookById(id: Long) =
        bookDao.findById(id).get().bookToBookDto()

    @Transactional
    override fun getAllBooks() =
        bookDao.findAll().map { it.bookToBookDto() }

    override fun deleteBookById(id: Long) =
        bookDao.deleteById(id)

    override fun updateBookNameById(id: Long, name: String) {
        bookDao.findById(id).get().let {
            it.name = name
            bookDao.save(it)
        }
    }


    override fun saveBook(book: BookDto) =
        bookDao.save(book.bookDtoToBook())
            .bookToBookDto()
}