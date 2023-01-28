package com.library.booklibrary.dao

import com.library.Authorlibrary.dao.AuthorDao
import com.library.booklibrary.model.Author
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Component
class AuthorDaoImpl(
    @PersistenceContext private val em: EntityManager,
) : AuthorDao {
    override fun findAuthorById(id: Long) =
        em.find(Author::class.java, id)

    override fun getAllAuthors() =
        em.createQuery("select b from Author b", Author::class.java)
            .resultList

    override fun deleteAuthorById(author: Author) =
        em.remove(author)

    override fun saveAuthor(author: Author) =
        if (author.id == null) {
            em.persist(author)
            author
        } else {
            em.merge(author)
        }
}