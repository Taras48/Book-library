package com.library.booklibrary.model

import com.library.booklibrary.dto.GenreDto
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name = "genres")
data class Genre(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(name = "name")
    var name: String,

    @OneToMany(targetEntity = Book::class)
    @Fetch(FetchMode.SUBSELECT)
    var books: MutableList<Book> = mutableListOf()
)

