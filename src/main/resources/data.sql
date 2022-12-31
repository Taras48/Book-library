insert into geners (`name`) values ('gener1');
insert into geners (`name`) values ('gener2');
insert into geners (`name`) values ('gener3');
insert into geners (`name`) values ('gener4');
insert into geners (`name`) values ('gener5');

insert into books (`name`, `gener_id`) values ('book1',  ( SELECT id FROM geners WHERE id = 1 ));
insert into books (`name`, `gener_id`) values ('book2',  ( SELECT id FROM geners WHERE id = 2 ));
insert into books (`name`, `gener_id`) values ('book3',  ( SELECT id FROM geners WHERE id = 3 ));
insert into books (`name`, `gener_id`) values ('book4',  ( SELECT id FROM geners WHERE id = 4 ));
insert into books (`name`, `gener_id`) values ('book5',  ( SELECT id FROM geners WHERE id = 5 ));


insert into authors (`surname`, `book_id`) values ('author1',  ( SELECT id FROM geners WHERE id = 1 ));
insert into authors (`surname`, `book_id`) values ('author2',  ( SELECT id FROM geners WHERE id = 2 ));
insert into authors (`surname`, `book_id`) values ('author1',  ( SELECT id FROM geners WHERE id = 3 ));
insert into authors (`surname`, `book_id`) values ('author2',  ( SELECT id FROM geners WHERE id = 1 ));