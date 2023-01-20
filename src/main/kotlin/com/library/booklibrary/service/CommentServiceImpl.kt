package com.library.booklibrary.service

import com.library.Commentlibrary.dao.CommentDao
import com.library.Commentlibrary.service.CommentService
import com.library.booklibrary.dto.CommentDto
import com.library.booklibrary.dto.commentDtoToComment
import com.library.booklibrary.model.commentToCommentDto
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class CommentServiceImpl(
    private val commentDao: CommentDao
): CommentService {
    override fun findCommentById(id: Long) =
        commentDao.findCommentById(id)
            ?.commentToCommentDto()

    override fun getAllComments() =
        commentDao.getAllComments()
            ?.map { it.commentToCommentDto() }

    override fun deleteCommentById(id: Long) =
        commentDao.deleteCommentById(id)

    override fun updateCommentTextById(id: Long, text: String) =
        commentDao.updateCommentTextById(id, text)

    override fun saveComment(comment: CommentDto) =
        commentDao.saveComment(comment.commentDtoToComment())
            .commentToCommentDto()
}