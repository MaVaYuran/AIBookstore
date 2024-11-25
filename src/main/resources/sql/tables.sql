CREATE TABLE IF NOT EXISTS book(
 id SERIAL PRIMARY KEY,
 title VARCHAR(128) NOT NULL UNIQUE,
 price NUMERIC(10,2) NOT NULL CHECK (price>0),
 );

CREATE TABLE IF NOT EXISTS customer(
id SERIAL PRIMARY KEY,
name VARCHAR(64) NOT NULL,
email VARCHAR(128) NOT NULL UNIQUE,
);

CREATE TYPE OrderStatus AS ENUM(
'open', 'complete', 'cancelled'
);

CREATE TABLE IF NOT EXISTS order_t (
id SERIAL PRIMARY KEY,
customer_id INT NOT NULL,
total_price NUMERIC(10, 2) CHECK(total_price >0),
status VARCHAR(50) NOT NULL DEFAULT 'open',
opening_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
closing_timestamp TIMESTAMP,
FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE book_order_t (
book_id INT REFERENCES book(id) ON DELETE CASCADE,
order_t_id INT REFERENCES order_t(id) ON DELETE CASCADE,
PRIMARY KEY (book_id, order_t_id)
);
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

insert into customer (name, email) values('Ivan', 'ivan@tut.by');
insert into customer (name, email) values('Olga', 'olga@gmail.com');
insert into customer (name, email) values('Dima', 'dima@gmail.com');
insert into customer (name, email) values('Ruslana', 'ruslana@mail.fr');

insert into order_t (customer_id, total_price) values (1, 15.89);
insert into order_t (customer_id, total_price) values (2, 5.99);
insert into order_t (customer_id, total_price) values (3, 10.95);
insert into order_t (customer_id, total_price) values (4, 38.59);

insert into book_order_t values(7, 1);
insert into book_order_t values(14, 2);
insert into book_order_t values(12, 3);
insert into book_order_t values(11, 4);
