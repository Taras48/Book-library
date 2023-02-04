package com.library.booklibrary.model

import javax.persistence.*

@Entity
@Table(name = "comments")
class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "text")
    var text: String? = null,

    @ManyToOne(targetEntity = Book::class,fetch = FetchType.LAZY)
    var book: Book? = null,
)

