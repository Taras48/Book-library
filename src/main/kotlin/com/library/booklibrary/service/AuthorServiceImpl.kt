package com.library.booklibrary.service

import com.library.Authorlibrary.dao.AuthorDao
import com.library.booklibrary.dto.AuthorDto
import com.library.booklibrary.extensions.authorDtoToAuthor
import com.library.booklibrary.extensions.authorToAuthorDto
import org.springframework.stereotype.Service
import javax.transaction.Transactional
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

    @Transactional
    override fun deleteAuthorById(author: AuthorDto) =
        authorDao.deleteAuthorById(author.authorDtoToAuthor())

    @Transactional
    override fun updateAuthorNameById(id: Long, name: String){
        authorDao.findAuthorById(id)?.let {
            it.name = name
            authorDao.saveAuthor(it)
        }
    }
    @Transactional
    override fun saveAuthor(author: AuthorDto) =
        authorDao.save(author.authorDtoToAuthor()).authorToAuthorDto()
}