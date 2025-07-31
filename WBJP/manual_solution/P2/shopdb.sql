CREATE DATABASE shopdb;
USE shopdb;

CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

INSERT INTO products (name, price) VALUES
('Laptop', 60000.00),
('Mobile', 25000.00),
('Tablet', 30000.00),
('Headphones', 2000.00);
