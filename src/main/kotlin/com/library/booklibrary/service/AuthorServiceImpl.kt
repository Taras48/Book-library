package com.library.booklibrary.service

import com.library.booklibrary.dao.AuthorDao
import com.library.booklibrary.dto.AuthorDto
import com.library.booklibrary.extensions.authorDtoToAuthor
import com.library.booklibrary.extensions.authorToAuthorDto
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class AuthorServiceImpl(
    val authorDao: AuthorDao,
) : AuthorService {
    override fun findAuthorById(id: Long) =
        authorDao.findById(id).get().authorToAuthorDto()


    override fun getAllAuthors() =
        authorDao.findAll()
            .map { it.authorToAuthorDto() }

    @Transactional
    override fun deleteAuthorById(id: Long) =
        authorDao.findById(id)
            .get()
            .let {
                authorDao.delete(it)
            }

    @Transactional
    override fun updateAuthorNameById(id: Long, name: String) {
        authorDao.findById(id).get().let {
            it.name = name
            authorDao.save(it)
        }
    }

    @Transactional
    override fun saveAuthor(author: AuthorDto) =
        authorDao.save(author.authorDtoToAuthor()).authorToAuthorDto()
}