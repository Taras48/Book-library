package com.library.Commentlibrary.dao

import com.library.booklibrary.model.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentDao : JpaRepository<Comment, Long>{
}