create table password_black_list
(
    id  serial primary key,
    bad_password varchar(20) not null
);

insert into password_black_list(bad_password)
values ('qwerty');
insert into password_black_list(bad_password)
values ('alsu');
insert into password_black_list(bad_password)
values ('marsel');
insert into password_black_list(bad_password)
values ('sun');
insert into password_black_list(bad_password)
values ('xrtt');
