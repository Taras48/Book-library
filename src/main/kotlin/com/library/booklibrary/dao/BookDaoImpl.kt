package com.library.booklibrary.dao

import com.library.booklibrary.model.Book
import org.springframework.stereotype.Component
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Component
class BookDaoImpl() : BookDao {
    @PersistenceContext
    private lateinit var em: EntityManager
    override fun findBookById(id: Long) =
        em.createQuery(
            """
            select b 
            from Book b
            where b.id = :id
            """.trimIndent(), Book::class.java
        )
            .setParameter("id", id)
            .setHint("javax.persistence.fetchgraph", em.getEntityGraph("book-entity-graph"))
            .singleResult
//
//        val entityGraph = em.getEntityGraph("book-entity-graph")
//        val properties = mapOf("javax.persistence.fetchgraph" to entityGraph)
//
//        return em.find(Book::class.java, id, properties)
//    }


    override fun getAllBooks() =
        em.createQuery(
            """
            select b 
            from Book b
            """.trimIndent(), Book::class.java
        )
            .setHint("javax.persistence.fetchgraph", em.getEntityGraph("book-entity-graph"))
            .resultList

    override fun saveBook(book: Book):Book{
        val newBook = if (book.id == null) {
            em.persist(book)

            book
        } else {
            em.merge(book)
        }
        em.flush()
        return newBook
    }


    override fun deleteBookById(book: Book) {
        em.remove(book)
        em.flush()
    }
}