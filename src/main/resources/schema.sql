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

CREATE TABLE books
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255),
    genre_id bigint references genres (id),
    CONSTRAINT pk_books PRIMARY KEY (id)
);

CREATE TABLE author_books
(
    author_id bigint references authors (id) on delete cascade,
    book_id   bigint references books (id) on delete cascade
);

CREATE TABLE comments
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    text    VARCHAR(255),
    book_id bigint references books (id) on delete cascade,
    CONSTRAINT pk_comments PRIMARY KEY (id)
);