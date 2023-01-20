package com.library.booklibrary.dao

import com.library.Authorlibrary.dao.AuthorDao
import com.library.booklibrary.model.Author
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class AuthorDaoImpl(
    @PersistenceContext private val em: EntityManager,
) : AuthorDao {
    override fun findAuthorById(id: Long) =
        em.find(Author::class.java, id)

    override fun getAllAuthors() =
        em.createQuery("select b from Author b", Author::class.java)
            .resultList

    override fun deleteAuthorById(id: Long) =
        em.createQuery("delete from Author where id = :id")
            .setParameter("id", id)
            .executeUpdate()

    override fun updateAuthorNameById(id: Long, name: String) =
        em.createQuery(
            """
            update Author b
                set b.name = :name
                where b.id = :id
                """
        )
            .setParameter("name", name)
            .setParameter("id", id)
            .executeUpdate()

    override fun saveAuthor(author: Author) =
        if (author.id == null) {
            em.persist(author)
            author
        } else {
            em.merge(author)
        }
}