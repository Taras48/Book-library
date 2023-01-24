package com.library.booklibrary.dao

import com.library.booklibrary.model.Book
import com.library.booklibrary.model.Genre
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Component
class GenreDaoImpl(
    @PersistenceContext
    private val em: EntityManager
):GenreDao {
    override fun findGenreById(id: Long) =
        em.find(Genre::class.java, id)

    override fun getAllGenres() =
        em.createQuery("select b from Genre b", Genre::class.java)
            .resultList

    override fun deleteGenreById(genre: Genre) =
        em.remove(genre)

    override fun updateGenreNameById(id: Long, name: String) =
        em.createQuery(
            """
            update Genre b
                set b.name = :name
                where b.id = :id
                """
        )
            .setParameter("name", name)
            .setParameter("id", id)
            .executeUpdate()

    override fun saveGenre(genre: Genre) =
        if (genre.id == null) {
            em.persist(genre)
            genre
        } else {
            em.merge(genre)
        }
}