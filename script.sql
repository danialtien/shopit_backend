use sakila;

DROP DATABASE IF EXISTS ShopIT;

CREATE DATABASE ShopIT;
USE ShopIT;

-- Create the customer table
CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20),
    password VARCHAR(20),
    avatar VARCHAR(255),
    address VARCHAR(255),
    created_at DATETIME,
    status BOOLEAN
);

-- Create the notification table
CREATE TABLE notification (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    created_at DATETIME,
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);

-- Create the order table
CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    shipping_address VARCHAR(255),
    total_price DECIMAL(10, 2),
    status ENUM('Pending', 'Success', 'Cancel'),
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);

-- Create the payment table
CREATE TABLE payment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    payment_date DATE,
    amount DECIMAL(10, 2),
    payment_method ENUM('Card', 'Cash'),
    FOREIGN KEY (order_id) REFERENCES `orders` (id)
);

-- Create the shop table
CREATE TABLE shop (
    id INT AUTO_INCREMENT PRIMARY KEY,
    shop_name VARCHAR(100),
    address VARCHAR(255),
    phone VARCHAR(20),
    status BOOLEAN
);

-- Create the category table
CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(100)
);

-- Create the product table
CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category_id INT,
    product_name VARCHAR(100),
    status BOOLEAN,
    unit_in_stock INT,
    unit_price DECIMAL(10, 2),
    url_image VARCHAR(255),
    description TEXT,
    FOREIGN KEY (category_id) REFERENCES category (id)
);

-- Create the orderDetail table
CREATE TABLE order_detail (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    product_id INT,
    quantity INT,
    price DECIMAL(10, 2),
    total DECIMAL(10, 2),
    FOREIGN KEY (order_id) REFERENCES `orders` (id),
    FOREIGN KEY (product_id) REFERENCES product (id)
);

-- Insert sample data for categories
INSERT INTO category (category_name) VALUES
    ('DELL'),
    ('Macbook'),
    ('Acer'),
    ('Asus');

-- Insert sample data for products
INSERT INTO product (category_id, product_name, status, unit_in_stock, unit_price, url_image, description) VALUES
    (1, 'DELL Laptop 1', true, 10, 1500.00, 'https://example.com/image1.jpg', 'Description for DELL Laptop 1'),
    (1, 'DELL Laptop 2', true, 5, 1800.00, 'https://example.com/image2.jpg', 'Description for DELL Laptop 2'),
    (2, 'Macbook Pro', true, 8, 2000.00, 'https://example.com/image3.jpg', 'Description for Macbook Pro'),
    (3, 'Acer Laptop', true, 12, 1200.00, 'https://example.com/image4.jpg', 'Description for Acer Laptop'),
    (4, 'Asus Laptop', true, 15, 1400.00, 'https://example.com/image5.jpg', 'Description for Asus Laptop');

-- Insert sample data for customer, notification, order, and payment tables
INSERT INTO customer (full_name, email, phone, password, avatar, address, created_at, status) VALUES
    ('John Doe', 'john.doe@example.com', '123456789', '12345', '', '123 Main St', NOW(), true),
    ('Manh Tien', 'tien@gmail.com', '123456789', '12345', '', '123 Main St', NOW(), true),
    ('Jane Smith', 'demo@demo.com', '987654321', '123456', '', '456 Elm St', NOW(), true);

INSERT INTO notification (customer_id, title, description, created_at) VALUES
    (1, 'Notification 1', 'Description for Notification 1', NOW()),
    (2, 'Notification 2', 'Description for Notification 2', NOW());

INSERT INTO `orders` (customer_id, order_date, shipping_address, total_price, status) VALUES
    (1, '2023-01-01', '789 Oak St', 2500.00, 'Success'),
    (2, '2023-02-02', '321 Pine St', 1800.00, 'Pending');

INSERT INTO payment (order_id, payment_date, amount, payment_method) VALUES
    (1, '2023-01-02', 2500.00, 'Card'),
    (2, '2023-02-03', 1800.00, 'Cash');
    
-- ALTER TABLE customer CHANGE createdAt created_at DATETIME;
