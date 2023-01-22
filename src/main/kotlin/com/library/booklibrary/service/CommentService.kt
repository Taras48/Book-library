package com.library.Commentlibrary.service

import com.library.booklibrary.dto.CommentDto

interface CommentService {
    /**
     * Получение комментария по id
     *
     * @param id  идентификатор комментария
     * @return комментарий
     */
    fun findCommentById(id: Long): CommentDto?

    /**
     * Получение всех комментариев
     *
     * @return все комментарии
     */
    fun getAllComments(): List<CommentDto>?

    /**
     * Получение всех комментариев по id книги
     *
     * @return комментарии
     */
    fun getCommentsByBookId(id:Long): List<CommentDto>?

    /**
     * Удаление комментария по id
     *
     * @param id  идентификатор комментария
     *
     */
    fun deleteCommentById(id: Long)

    /**
     * Обновление комментария
     *
     * @param id     идентификатор комментария
     * @param text   текст комментария
     *
     */
    fun updateCommentTextById( id: Long, text: String)

    /**
     * Создание комментария
     *
     * @param comment  комментария
     * @return книга
     */
    fun saveComment(comment: CommentDto): CommentDto
}