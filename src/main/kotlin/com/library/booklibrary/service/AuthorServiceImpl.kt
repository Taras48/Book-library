package com.library.booklibrary.service

import com.library.Authorlibrary.dao.AuthorDao
import com.library.booklibrary.dto.AuthorDto
import com.library.booklibrary.extensions.authorDtoToAuthor
import com.library.booklibrary.extensions.authorToAuthorDto
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class AuthorServiceImpl(
    private val authorDao: AuthorDao,
) : AuthorService {
    override fun findAuthorById(id: Long) =
        authorDao.findById(id).get().authorToAuthorDto()


    override fun getAllAuthors() =
        authorDao.findAll()
            .map { it.authorToAuthorDto() }

    override fun deleteAuthorById(id: Long) =
        authorDao.deleteById(id)

    @Transactional
    override fun updateAuthorNameById(id: Long, name: String) {
        authorDao.findById(id).get().let {
            it.name = name
            authorDao.save(it)
        }
    }

    override fun saveAuthor(author: AuthorDto) =
        authorDao.save(author.authorDtoToAuthor()).authorToAuthorDto()
}