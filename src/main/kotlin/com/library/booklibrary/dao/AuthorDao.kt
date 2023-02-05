package com.library.Authorlibrary.dao

import com.library.booklibrary.model.Author
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorDao : JpaRepository<Author, Long> {
}