package com.library.booklibrary.service

import com.library.booklibrary.dao.GenreDao
import com.library.booklibrary.dto.GenreDto
import com.library.booklibrary.extensions.genreDtoToGenre
import com.library.booklibrary.extensions.genreToGenreDto
import com.library.booklibrary.model.Genre
import org.springframework.stereotype.Service

@Service
class GenreServiceImpl(
    private val genreDao: GenreDao,
) : GenreService {
    override fun findGenreById(id: Long) =
        genreDao.findGenreById(id)
            ?.genreToGenreDto()

    override fun getAllGenres() =
        genreDao.getAllGenres()
            ?.map { it.genreToGenreDto() }

    override fun deleteGenreById(genre: GenreDto) =
        genreDao.deleteGenreById(genre.genreDtoToGenre())

    override fun updateGenreNameById(id: Long, name: String) =
        genreDao.updateGenreNameById(id, name)

    override fun saveGenre(genre: GenreDto) =
        genreDao.saveGenre(genre.genreDtoToGenre()).genreToGenreDto()
}