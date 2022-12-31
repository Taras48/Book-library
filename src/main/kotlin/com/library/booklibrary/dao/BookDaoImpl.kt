package com.library.booklibrary.dao

import com.library.booklibrary.model.Author
import com.library.booklibrary.model.Book
import com.library.booklibrary.model.Genre
import org.springframework.jdbc.core.ResultSetExtractor
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Service

@Service
class BookDaoImpl(
    private val jdbc: NamedParameterJdbcTemplate,
) : BookDao {

    private companion object {
        val EXTRACTOR = ResultSetExtractor<List<Book>> { rs ->
            val books = mutableListOf<Book>()

            while (rs.next()) {
                books.add(
                    Book(
                        rs.getLong("book_id"),
                        rs.getString("book_name"),
                        gener = Genre(
                            rs.getLong("gener_id"),
                            rs.getString("gener_name")
                        )
                    )
                )
            }

            books
        }
    }

    override fun findBookById(id: Long) =
        jdbc.query(
            """select b.id book_id, b.name book_name, g.id gener_id, g.name gener_name
                from books b
                left join geners g
                on b.gener_id = g.id
                """.trimMargin(),
            EXTRACTOR
        )?.firstOrNull()?.let {
            it.authors.plus(getAuthorsForBooks()[it.id])

            it
        }

    override fun getAllBooks(): List<Book>? {
        val books = jdbc.query(
            """select b.id book_id, b.name book_name, g.id gener_id, g.name gener_name
                from books b
                left join geners g
                on b.gener_id = g.id
                """.trimMargin(),
            EXTRACTOR
        )
        val authorsForBooks = getAuthorsForBooks()

        books?.map {
            it.authors.plus(authorsForBooks[it.id])
        }

        return books
    }

    private fun getAuthorsForBooks(): Map<Long, List<Author>> {
        return jdbc.query(
            """select b.id  book_id, a.surname as author_name, a.id as author_id
               from books b
               left join authors a on a.book_id = b.id
                """.trimMargin()
        ) { rs ->
            val booksWithAuthors = mutableMapOf<Long, MutableList<Author>>()

            while (rs.next()) {
                val bookId = rs.getLong("book_id");
                booksWithAuthors.putIfAbsent(bookId, mutableListOf())

                booksWithAuthors.get(bookId)!!.add(
                    Author(
                        rs.getLong("author_id"),
                        rs.getString("author_name")
                    )
                )
            }

            booksWithAuthors
        } as Map<Long, List<Author>>
    }


    override fun deleteBookById(id: Long) =
        jdbc.update("delete from books where id = :id", mapOf("id" to id))

    override fun insertBook(book: Book): Long {
        val keyHolder = GeneratedKeyHolder()

        jdbc.update(
            "insert into books (name) values(:name)",
            MapSqlParameterSource(
                mapOf("name" to book.name)
            ),
            keyHolder,
            listOf("id").toTypedArray()
        )

        return keyHolder.keys?.get("id") as Long
    }

    override fun updateBook(book: Book) {
        jdbc.update("update books name = :name where id = :Id", mapOf("id" to book.id, "name" to book.name))
    }
}