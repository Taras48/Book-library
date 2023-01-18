package com.library.booklibrary.dao

import com.library.Commentlibrary.dao.CommentDao
import com.library.booklibrary.model.Comment
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class CommentDaoImpl(
    @PersistenceContext private val em: EntityManager,
) : CommentDao {
    override fun findCommentById(id: Long) =
        em.find(Comment::class.java, id)

    override fun getAllComments() =
        em.createQuery("select c from Comment c", Comment::class.java)
            .resultList

    override fun deleteCommentById(id: Long) =
        em.createQuery("delete from Comment where id = :id")
            .setParameter("id", id)
            .executeUpdate()

    override fun updateComment(comment: Comment) =
        em.createQuery(
            """
            update Comment c
                set c.text = :text
                where c.id = :id
                """
        )
            .setParameter("text", comment.text)
            .setParameter("id", comment.id)
            .executeUpdate()

    override fun saveComment(comment: Comment) =
        if (comment.id?.equals(0) == true) {
            em.persist(comment)
            comment
        } else {
            em.merge(comment)
        }
}