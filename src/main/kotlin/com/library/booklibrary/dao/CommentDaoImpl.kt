package com.library.booklibrary.dao

import com.library.Commentlibrary.dao.CommentDao
import com.library.booklibrary.model.Comment
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Component
class CommentDaoImpl(
    @PersistenceContext private val em: EntityManager,
) : CommentDao {
    override fun findCommentById(id: Long) =
        em.find(Comment::class.java, id)

    override fun getAllComments() =
        em.createQuery("select c from Comment c", Comment::class.java)
            .resultList

    override fun deleteCommentById(comment: Comment) =
        em.remove(comment)

    override fun updateCommentTextById(id: Long, text: String) =
        em.createQuery(
            """
            update Comment c
                set c.text = :text
                where c.id = :id
                """
        )
            .setParameter("text", text)
            .setParameter("id", id)
            .executeUpdate()

    override fun saveComment(comment: Comment) =
        if (comment.id == null) {
            em.persist(comment)
            comment
        } else {
            em.merge(comment)
        }
}