package com.library.booklibrary.dao

import com.library.booklibrary.model.Book
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface BookDao : JpaRepository<Book, Long> {
    @EntityGraph(attributePaths = arrayOf("gener"))
    override fun findAll(): List<Book>
}