package com.library.booklibrary.service

import com.library.booklibrary.dto.UserDto

interface UserService {
    /**
     * Получение пользователя по id
     *
     * @param id  идентификатор пользователя
     * @return пользователь
     */
    fun findUserById(id: Long): UserDto?

    /**
     * Получение всех пользователей
     *
     * @return все пользователи
     */
    fun getUsers(): List<UserDto>?

    /**
     * Удаление пользователя по id
     *
     * @param id  идентификатор пользователя
     *
     */
    fun deleteUserById(id: Long)

    /**
     * Обновление пользователя
     *
     * @param id    идентификатор пользователя
     * @param name  имя пользователя
     *
     */
    fun updateUserNameById(id: Long, name: String)

    /**
     * Создание пользователя
     *
     * @param book  пользователя
     * @return пользователя
     */
    fun saveUser(user: UserDto): UserDto
}