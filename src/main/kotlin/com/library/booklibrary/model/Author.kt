package com.library.booklibrary.model

import com.library.booklibrary.dto.AuthorDto
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name = "authors")
class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column(name = "sur_name")
    val name: String?
)


fun Author.authorToAuthorDto() =
    AuthorDto(
        this.id,
        this.name
    )