package com.library.booklibrary.dao

import com.library.booklibrary.model.Genre
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface GenreDao : JpaRepository<Genre, Long> {
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Genre b set b.name = :name where b.id = :id")
    fun updateNameById(@Param("id") id: Long, @Param("name") name: String)
}