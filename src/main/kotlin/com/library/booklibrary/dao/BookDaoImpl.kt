package com.library.booklibrary.dao

import com.library.booklibrary.model.Book
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Component
class BookDaoImpl() : BookDao {
    @PersistenceContext
    private lateinit var em: EntityManager
    override fun findBookById(id: Long) =
        em.find(Book::class.java, id)

    override fun getAllBooks() =
        em.createQuery(
            """
            select b 
            from Book b
            join fetch b.gener 
            """.trimIndent(), Book::class.java
        )
            .resultList

    override fun deleteBookById(book:Book) =
        em.remove(book)

    override fun saveBook(book: Book) =
        if (book.id == null) {
            em.persist(book)
            book
        } else {
            em.merge(book)
        }

    override fun updateBookNameById(id: Long, name: String) =
        em.createQuery(
            """
            update Book b
                set b.name = :name
                where b.id = :id
                """
        )
            .setParameter("name", name)
            .setParameter("id", id)
            .executeUpdate()

}