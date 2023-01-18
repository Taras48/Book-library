package com.library.booklibrary.dto

import com.library.booklibrary.model.Comment

data class CommentDto(
    val id: Long? = null,
    val text: String? = null
)

fun CommentDto.commentDtoToComment() =
    Comment(
        this.id,
        this.text,
    )