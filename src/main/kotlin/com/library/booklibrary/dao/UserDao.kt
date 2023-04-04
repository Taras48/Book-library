package com.library.booklibrary.dao

import com.library.booklibrary.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserDao : JpaRepository<User, Long> {
    fun findUserByName(name:String):User?
}