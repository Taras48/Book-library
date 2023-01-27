package com.library.Commentlibrary.dao

import com.library.booklibrary.model.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CommentDao : JpaRepository<Comment, Long>{

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Comment c set c.text = :name where c.id = :id")
    fun updateTextById(@Param("id") id: Long, @Param("text") text: String)
}