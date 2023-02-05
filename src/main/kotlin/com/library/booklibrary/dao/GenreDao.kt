package com.library.booklibrary.dao

import com.library.booklibrary.model.Genre
import org.springframework.data.jpa.repository.JpaRepository

interface GenreDao : JpaRepository<Genre, Long> {
}