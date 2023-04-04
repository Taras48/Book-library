package com.library.booklibrary.model

import javax.persistence.*


@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column(name = "name")
    var name: String,

    @Column(name = "password")
    var password: String,

    @Column(name = "role")
    var role: String,
)