--changeset mariayuran:1
CREATE TABLE IF NOT EXISTS book(
 id SERIAL PRIMARY KEY,
 title VARCHAR(128) NOT NULL UNIQUE,
 price NUMERIC(10,2) NOT NULL CHECK (price>0),
 );
--changeset mariayuran:2
CREATE TABLE IF NOT EXISTS customer(
id SERIAL PRIMARY KEY,
name VARCHAR(64) NOT NULL,
email VARCHAR(128) NOT NULL UNIQUE,
);

--changeset mariayuran:3
CREATE TABLE IF NOT EXISTS order_t (
id SERIAL PRIMARY KEY,
customer_id INT NOT NULL,
total_price NUMERIC(10, 2) DEFAULT 0 ,
status VARCHAR(50) NOT NULL DEFAULT 'open',
opening_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
closing_timestamp TIMESTAMP,
FOREIGN KEY (customer_id) REFERENCES customer(id)
);

----changeset mariayuran:4
CREATE TABLE book_order_t (
book_id INT REFERENCES book(id) ON DELETE CASCADE,
order_t_id INT REFERENCES order_t(id) ON DELETE CASCADE,
PRIMARY KEY (book_id, order_t_id)
);