package com.library.booklibrary.model

import com.library.booklibrary.dto.CommentDto
import javax.persistence.*

@Entity
@Table(name = "comments")
class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "text")
    var text: String? = null,

    @ManyToOne(cascade = [CascadeType.ALL], targetEntity = Book::class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id")
    var book: Book? = null,
)

