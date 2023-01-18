package com.library.booklibrary.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.library.booklibrary.dto.BookDto
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name = "books")
class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "name")
    val name: String,

    @OneToMany(targetEntity = Comment::class, cascade = [CascadeType.ALL])
    @JoinColumn(name = "book_id")
    @Fetch(FetchMode.SUBSELECT)
    var comments: MutableList<Comment> = mutableListOf(),

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinTable(name = "author_books",
        joinColumns = [JoinColumn(name = "author_id")],
        inverseJoinColumns = [JoinColumn(name = "book_id")])
    @JsonIgnoreProperties("books")
    var authors: MutableList<Author> = mutableListOf()
)

fun Book.bookToBookDto() =
    BookDto(
        this.id,
        this.name,
        this.authors.map { it.authorToAuthorDto() }.toMutableList(),
        this.comments.map { it.commentToCommentDto()}.toMutableList()
    )


