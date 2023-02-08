package com.library.booklibrary.model

import org.springframework.lang.Nullable
import javax.persistence.*

@NamedEntityGraph(
    name = "book-entity-graph",
    attributeNodes = [
        NamedAttributeNode("authors"),
        NamedAttributeNode("gener")
    ]
)
@Entity
@Table(name = "books")
class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "name")
    var name: String,

    @ManyToMany(cascade = [CascadeType.PERSIST])
    @JoinTable(
        name = "author_books",
        joinColumns = [JoinColumn(name = "author_id")],
        inverseJoinColumns = [JoinColumn(name = "book_id")]
    )
    var authors: MutableList<Author> = mutableListOf(),

    @ManyToOne(targetEntity = Genre::class, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "genre_id", nullable = true)
    var gener: Genre? = null,

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var comments: MutableList<Comment> = mutableListOf(),
)


