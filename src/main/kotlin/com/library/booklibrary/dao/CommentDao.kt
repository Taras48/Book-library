package com.library.Commentlibrary.dao

import com.library.booklibrary.model.Comment

interface CommentDao {

    /**
     * Получение комментария по id
     *
     * @param id  идентификатор комментария
     * @return книга
     */
    fun findCommentById(id: Long): Comment?

    /**
     * Получение всех комментариев
     *
     * @return все комментарии
     */
    fun getAllComments(): List<Comment>?

    /**
     * Удаление комментария по id
     *
     * @param id  идентификатор комментария
     * @return  количество удаленных строк
     */
    fun deleteCommentById(comment: Comment)

    /**
     * Обновление комментария
     *
     * @param comment  комментарий
     * @return количество измененных строк
     */
    fun updateCommentTextById(id: Long, text: String): Int

    /**
     * Создание комментария
     *
     * @param comment  комментария
     * @return комментария
     */
    fun saveComment(comment: Comment): Comment
}