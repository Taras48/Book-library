package com.library.Authorlibrary.dao

import com.library.booklibrary.model.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface AuthorDao : JpaRepository<Author, Long> {
}