CREATE TABLE users
(
    id BIGSERIAL primary key ,
    name varchar(64) not null,
    age integer not null default 10,
    email varchar(64)
);

insert into users (name, age, email) values ('Aibulat', 20, 'medmezt@gmail.com');
insert into users (name, age, email) values ('Kostya', 23, 'zmedt@gmail.com');
insert into users (name, age, email) values ('Yasha', 22, 'sasdyashadt@gmail.com');
insert into users (name, age, email) values ('Sergei', 24, 'yashadt1@gmail.com');

SELECT * FROM users;

SELECT max(id) from users;

select name from users where id = 1;

DROP TABLE users;