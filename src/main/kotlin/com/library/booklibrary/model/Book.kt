package com.library.booklibrary.model

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
    var name: String,

    @OneToMany(
        targetEntity = Comment::class,
        cascade = [CascadeType.ALL],
        orphanRemoval = true,

        )
    @JoinColumn(name = "book_id")
    @Fetch(FetchMode.SUBSELECT)
    var comments: MutableList<Comment> = mutableListOf(),

    @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.PERSIST])
    @JoinTable(
        name = "author_books",
        joinColumns = [JoinColumn(name = "author_id")],
        inverseJoinColumns = [JoinColumn(name = "book_id")]
    )
    @Fetch(FetchMode.SUBSELECT)
    var authors: MutableList<Author> = mutableListOf(),

    @ManyToOne(targetEntity = Genre::class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "genre_id")
    var gener: Genre? = null,
)


