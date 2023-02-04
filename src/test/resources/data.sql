insert into genres(`name`)
values ('gener1'),
       ('gener2');

insert into authors (`sur_name`)
values ('author1'),
       ('author2');

insert into books (`name`, `genre_id`)
values ('book1', 1),
       ('book2', 2);

insert into author_books (`author_id`, `book_id`)
values (1, 1),
       (2, 2),
       (2, 1);

insert into comments (`text`, `book_id`)
values ('text1', 1),
       ('text2', 2),
       ('text3', 1);
