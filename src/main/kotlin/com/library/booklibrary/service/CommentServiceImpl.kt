package com.library.booklibrary.service

import com.library.Commentlibrary.dao.CommentDao
import com.library.Commentlibrary.service.CommentService
import com.library.booklibrary.dto.CommentDto
import com.library.booklibrary.extensions.commentDtoToComment
import com.library.booklibrary.extensions.commentToCommentDto
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class CommentServiceImpl(
    private val commentDao: CommentDao,
    private val bookService: BookService,
) : CommentService {
    override fun findCommentById(id: Long) =
        commentDao.findById(id).get()
            .commentToCommentDto()

    override fun getAllComments() =
        commentDao.findAll()
            .map { it.commentToCommentDto() }

    override fun getCommentsByBookId(id: Long) =
        bookService.findBookById(id)?.comments

    override fun deleteCommentById(id: Long) =
        commentDao.deleteById(id)

    @Transactional
    override fun updateCommentTextById(id: Long, text: String) {
        commentDao.findById(id).get().let {
            it.text = text
            commentDao.save(it)
        }
    }

    override fun saveComment(comment: CommentDto) =
        commentDao.save(comment.commentDtoToComment())
            .commentToCommentDto()
}