package com.library.booklibrary.service

import com.library.Authorlibrary.dao.AuthorDao
import com.library.booklibrary.dto.AuthorDto
import com.library.booklibrary.extensions.authorDtoToAuthor
import com.library.booklibrary.extensions.authorToAuthorDto
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.toList

@Service
class AuthorServiceImpl(
    val authorDao: AuthorDao,
) : AuthorService {
    override fun findAuthorById(id: Long) =
        authorDao.findById(id).get().authorToAuthorDto()


    override fun getAllAuthors() =
        authorDao.findAll()
            .map { it.authorToAuthorDto() }

    override fun deleteAuthorById(id: Long) =
        authorDao.deleteById(id)

    override fun updateAuthorNameById(id: Long, name: String) =
        authorDao.updateNameById(id, name)

    override fun saveAuthor(author: AuthorDto) =
        authorDao.save(author.authorDtoToAuthor()).authorToAuthorDto()
}