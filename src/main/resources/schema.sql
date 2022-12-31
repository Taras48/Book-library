DROP TABLE IF EXISTS GENERS;
CREATE TABLE GENERS
(
    ID   BIGINT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(255)
);

DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS
(
    ID       BIGINT PRIMARY KEY AUTO_INCREMENT,
    NAME     VARCHAR(255),
    GENER_ID BIGINT references GENERS (ID)
);


DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS(
    ID   BIGINT PRIMARY KEY AUTO_INCREMENT,
    SURNAME VARCHAR(255),
    BOOK_ID BIGINT references BOOKS (ID)
);