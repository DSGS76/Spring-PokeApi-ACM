drop table if exists pokemon;
create table if not exists pokemon(
    id Integer not null primary key,
    name varchar(32) not null,
    height Integer not null,
    weight Integer not null
)