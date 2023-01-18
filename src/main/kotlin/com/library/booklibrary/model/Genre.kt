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
    val id: Long,

    @Column(name = "name")
    val name: String,

    @OneToMany(targetEntity = Book::class, cascade = [CascadeType.ALL])
    @JoinColumn(name = "genre_id")
    @Fetch(FetchMode.SUBSELECT)
    var books: MutableList<Book> = mutableListOf()
)


fun Genre.genreToGenreDto() =
    GenreDto(
        this.id,
        this.name
    )