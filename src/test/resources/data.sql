insert into books (`name`) values ('book1');
insert into books (`name`) values ('book2');
--
insert into geners (`name`, `book_id`) values ('gener1',  ( SELECT id FROM books WHERE id = 1 ));
insert into geners (`name`, `book_id`) values ('gener2',  ( SELECT id FROM books WHERE id = 2 ));

insert into authors (`name`, `book_id`) values ('author1',  ( SELECT id FROM geners WHERE id = 1 ));
insert into authors (`name`, `book_id`) values ('author2',  ( SELECT id FROM geners WHERE id = 2 ));
insert into authors (`name`, `book_id`) values ('author3',  ( SELECT id FROM geners WHERE id = 2 ));