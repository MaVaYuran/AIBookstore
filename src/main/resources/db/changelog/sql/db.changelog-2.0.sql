--changeset mariayuran:1
insert into book(title, price) values('The Lord of rings', 22.95);
insert into book(title, price) values('Hobbit', 18.75);
insert into book(title, price) values('Незнайка', 3.95);
insert into book(title, price) values('Мышонок пик', 2.5);
insert into book(title, price) values('Learn Java', 22.99);
insert into book(title, price) values('Harry Potter and the Philosophers stone', 15.89);
insert into book(title, price) values('Harry Potter and the Chamber of Secrets', 15.89);
insert into book(title, price) values('Harry Potter and the Prisoner of Azkaban', 15.89);
insert into book(title, price) values('Harry Potter and the Order of the Phoenix', 15.89);
insert into book(title, price) values( 'Harry Potter and the Deathly Hallows', 15.89);
insert into book(title, price) values('50 Shades of gray', 38.59);
insert into book(title, price) values('Romeo & Juliette', 10.95);
insert into book(title, price) values('Frida', 5.99);
insert into book(title, price) values('The Alchemist', 5.99);
insert into book(title, price) values('The witch of Portobello', 5.99);
insert into book(title, price) values('Ayvengo', 7.95);

--changeset mariayuran:2
insert into customer (name, email) values('Ivan', 'ivan@tut.by');
insert into customer (name, email) values('Olga', 'olga@gmail.com');
insert into customer (name, email) values('Dima', 'dima@gmail.com');
insert into customer (name, email) values('Ruslana', 'ruslana@mail.fr');

--changeset mariayuran:3
insert into order_t (customer_id, total_price) values (1, 15.89);
insert into order_t (customer_id, total_price) values (2, 5.99);
insert into order_t (customer_id, total_price) values (3, 10.95);
insert into order_t (customer_id, total_price) values (4, 38.59);

--changeset mariayuran:4
insert into book_order_t values(7, 1);
insert into book_order_t values(14, 2);
insert into book_order_t values(12, 3);
insert into book_order_t values(11, 4);
