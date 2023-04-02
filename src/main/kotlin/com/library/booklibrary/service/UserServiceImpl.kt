package com.library.booklibrary.service

import com.library.booklibrary.dao.UserDao
import com.library.booklibrary.dto.UserDto
import com.library.booklibrary.extensions.userDtoToUser
import com.library.booklibrary.extensions.userToUserDto
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userDao: UserDao,
) : UserService, UserDetailsService {
    override fun findUserById(id: Long) =
        userDao.findById(id).get().userToUserDto()

    override fun getUsers() =
        userDao.findAll().map { it.userToUserDto() }

    override fun deleteUserById(id: Long) =
        userDao.deleteById(id)

    override fun updateUserNameById(id: Long, name: String) {
        userDao.findById(id).get().let {
            it.name = name
            userDao.save(it)
        }
    }


    override fun saveUser(user: UserDto): UserDto {

        return userDao.save(user.userDtoToUser()).userToUserDto()
    }

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userDao.findUserByName(username) ?: throw UsernameNotFoundException("Unknown user: $username" )

        return User.builder()
            .username(user.name)
            .password(user.password)
            .roles(user.role)
            .build()
    }

}
