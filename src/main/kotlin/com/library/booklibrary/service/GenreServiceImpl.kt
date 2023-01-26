package com.library.booklibrary.service

import com.library.booklibrary.dao.GenreDao
import com.library.booklibrary.dto.GenreDto
import com.library.booklibrary.extensions.genreDtoToGenre
import com.library.booklibrary.extensions.genreToGenreDto
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class GenreServiceImpl(
    private val genreDao: GenreDao,
) : GenreService {
    @Transactional
    override fun findGenreById(id: Long) =
        genreDao.findById(id).get()
            .genreToGenreDto()

    @Transactional
    override fun getAllGenres() =
        genreDao.findAll()
            .map { it.genreToGenreDto() }

    override fun deleteGenreById(id: Long) =
        genreDao.deleteById(id)

    override fun updateGenreNameById(id: Long, name: String) =
        genreDao.updateNameById(id, name)

    override fun saveGenre(genre: GenreDto) =
        genreDao.save(genre.genreDtoToGenre()).genreToGenreDto()
}