create table book_copy2
(
    id bigserial primary key,
    name varchar(255)
);

create table book
(
    id bigserial primary key,
    name varchar(255),
    author varchar(255)
);