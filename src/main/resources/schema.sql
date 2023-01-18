CREATE TABLE genres
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_genres PRIMARY KEY (id)
);

CREATE TABLE authors
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    sur_name VARCHAR(255),
    CONSTRAINT pk_authors PRIMARY KEY (id)
);

CREATE TABLE author_books
(
    author_id BIGINT NOT NULL,
    book_id   BIGINT NOT NULL
);

CREATE TABLE books
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255),
    genre_id BIGINT,
    CONSTRAINT pk_books PRIMARY KEY (id)
);

ALTER TABLE books
    ADD CONSTRAINT FK_BOOKS_ON_GENRE FOREIGN KEY (genre_id) REFERENCES genres (id);

ALTER TABLE author_books
    ADD CONSTRAINT fk_autboo_on_author FOREIGN KEY (book_id) REFERENCES authors (id);

ALTER TABLE author_books
    ADD CONSTRAINT fk_autboo_on_book FOREIGN KEY (author_id) REFERENCES books (id);

CREATE TABLE comments
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    text    VARCHAR(255),
    book_id BIGINT,
    CONSTRAINT pk_comments PRIMARY KEY (id)
);

ALTER TABLE comments
    ADD CONSTRAINT FK_COMMENTS_ON_BOOK FOREIGN KEY (book_id) REFERENCES books (id);