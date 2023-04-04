package com.library.booklibrary.dto

data class UserDto(
    val id: Long? = null,
    var name: String,
    var password: String,
    var role: String,
)
