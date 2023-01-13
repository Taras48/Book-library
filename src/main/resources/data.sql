insert into books (`name`) values ('book1');
insert into books (`name`) values ('book2');
insert into books (`name`) values ('book3');
insert into books (`name`) values ('book4');
insert into books (`name`) values ('book5');
--
insert into geners (`name`, `book_id`) values ('gener1',  ( SELECT id FROM books WHERE id = 1 ));
insert into geners (`name`, `book_id`) values ('gener2',  ( SELECT id FROM books WHERE id = 2 ));
insert into geners (`name`, `book_id`) values ('gener3',  ( SELECT id FROM books WHERE id = 3 ));
insert into geners (`name`, `book_id`) values ('gener4',  ( SELECT id FROM books WHERE id = 4 ));
insert into geners (`name`, `book_id`) values ('gener5',  ( SELECT id FROM books WHERE id = 5 ));

insert into authors (`surname`, `book_id`) values ('author1',  ( SELECT id FROM geners WHERE id = 1 ));
insert into authors (`surname`, `book_id`) values ('author2',  ( SELECT id FROM geners WHERE id = 2 ));
insert into authors (`surname`, `book_id`) values ('author1',  ( SELECT id FROM geners WHERE id = 3 ));
insert into authors (`surname`, `book_id`) values ('author3',  ( SELECT id FROM geners WHERE id = 4 ));
insert into authors (`surname`, `book_id`) values ('author4',  ( SELECT id FROM geners WHERE id = 5 ));
insert into authors (`surname`, `book_id`) values ('author5',  ( SELECT id FROM geners WHERE id = 5 ));