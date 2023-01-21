package com.library.booklibrary.service

import com.library.Commentlibrary.dao.CommentDao
import com.library.Commentlibrary.service.CommentService
import com.library.booklibrary.dto.CommentDto
import com.library.booklibrary.extensions.commentDtoToComment
import com.library.booklibrary.extensions.commentToCommentDto
import org.springframework.stereotype.Service

@Service
class CommentServiceImpl(
    private val commentDao: CommentDao,
    private val bookService: BookService,
) : CommentService {
    override fun findCommentById(id: Long) =
        commentDao.findCommentById(id)
            ?.commentToCommentDto()

    override fun getAllComments() =
        commentDao.getAllComments()
            ?.map { it.commentToCommentDto() }

    override fun getCommentsByBookId(id: Long) =
        bookService.findBookById(id)?.comments

    override fun deleteCommentById(id: Long) =
        commentDao.deleteCommentById(id)

    override fun updateCommentTextById(id: Long, text: String) =
        commentDao.updateCommentTextById(id, text)

    override fun saveComment(comment: CommentDto) =
        commentDao.saveComment(comment.commentDtoToComment())
            .commentToCommentDto()
}