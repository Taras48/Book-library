package com.library.booklibrary.dao

import com.library.booklibrary.model.Author
import com.library.booklibrary.model.Book
import org.springframework.jdbc.core.ResultSetExtractor
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class BookDaoImpl(
    @PersistenceContext private val em: EntityManager
) : BookDao {

    override fun findBookById(id: Long) =
        em.find(Book::class.java, id)

    override fun getAllBooks() =
        em.createQuery("select b from Book b", Book::class.java)
            .resultList

    override fun deleteBookById(id: Long) =
        em.createQuery("delete from Book where id = :id")
            .setParameter("id", id)
            .executeUpdate()

    override fun saveBook(book: Book) =
        if (book.id == null) {
            em.persist(book)
            book
        } else {
            em.merge(book)
        }

    override fun updateBook(book: Book)=
        em.createQuery(
            """
            update Book b
                set b.name = :name, 
                b.authors = :authors,
                b.comments = :comments
                where b.id = :id
                """
        )
            .setParameter("name", book.name)
            .setParameter("authors", book.authors)
            .setParameter("comments", book.comments)
            .setParameter("id", book.id)
            .executeUpdate()

}