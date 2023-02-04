package com.library.booklibrary.service

import com.library.Commentlibrary.dao.CommentDao
import com.library.Commentlibrary.service.CommentService
import com.library.booklibrary.dao.BookDao
import com.library.booklibrary.dto.CommentDto
import com.library.booklibrary.extensions.commentDtoToComment
import com.library.booklibrary.extensions.commentToCommentDto
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class CommentServiceImpl(
    private val commentDao: CommentDao,
    private val bookDao: BookDao
) : CommentService {
    override fun findCommentById(id: Long) =
        commentDao.findCommentById(id)
            ?.commentToCommentDto()

    override fun getAllComments() =
        commentDao.getAllComments()
            ?.map { it.commentToCommentDto() }

    @Transactional
    override fun getCommentsByBookId(id: Long) =
        bookDao.findBookById(id)
            ?.comments
            ?.map { it.commentToCommentDto() }

    @Transactional
    override fun deleteCommentById(comment: CommentDto) =
        commentDao.deleteCommentById(comment.commentDtoToComment())

    @Transactional
    override fun updateCommentTextById(id: Long, text: String){
        commentDao.findCommentById(id)?.let {
            it.text = text
            commentDao.saveComment(it)
        }
    }

    @Transactional
    override fun saveComment(comment: CommentDto) =
        commentDao.saveComment(comment.commentDtoToComment())
            .commentToCommentDto()
}