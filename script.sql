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
    (1, 'Laptop gaming Dell Alienware M15 R6 P109F001DBL', true, 10, 1500.00, 'https://product.hstatic.net/200000722513/product/dbl_152e17726a35416c866baf151690a56b_bdc65b6069f94635b83cc2597aa81baf_master.png', 'One of the most popular high-end gaming laptops today with a special appearance and powerful configuration, this is also the child of the famous Dell brand for office laptops, which is Alienware. Today GEARVN will bring you a Dell Alienware M15 R6 P109F001DBL laptop, let see what the "alien" will be equipped with for us gamers!'),
    (1, 'Laptop gaming Dell Alienware M15 R6 P109F001CBL', true, 5, 1800.00, 'https://product.hstatic.net/200000722513/product/cbl_3c7efadff4d044ed9365ed0795268b21_d82e65828c4d47e69e572c8ae3a98ee9_master.png', 'One of the most popular high-end gaming laptops today with a special appearance and powerful configuration, this is also the child of the famous Dell brand for office laptops, which is Alienware. Today GEARVN will bring you a Dell Alienware M15 R6 P109F001DBL laptop, let see what the "alien" will be equipped with for us gamers!'),
    (2, 'MacBook Pro 13 M2 10GPU 8GB 512GB Space Gray', true, 8, 2000.00, 'https://file.hstatic.net/1000026716/file/gearvn-macbook-pro-13-m2-10gpu-8gb-512gb-space-gray-4_268184ce43d74227b0272efd91de53d6_grande.png', 'One of the most popular high-end gaming laptops today with a special appearance and powerful configuration, this is also the child of the famous Dell brand for office laptops, which is Alienware. Today GEARVN will bring you a Dell Alienware M15 R6 P109F001DBL laptop, let see what the "alien" will be equipped with for us gamers!'),
    (3, 'Laptop gaming Acer Predator Helios 16 PH16 71 72BV', true, 12, 2200.00, 'https://product.hstatic.net/200000722513/product/72bv_229a7d912f7047789dcb81d4dd833dd2_44e2aebdecbc470e85b8657a56e3263e_master.png', 'One of the most popular high-end gaming laptops today with a special appearance and powerful configuration, this is also the child of the famous Dell brand for office laptops, which is Alienware. Today GEARVN will bring you a Dell Alienware M15 R6 P109F001DBL laptop, let see what the "alien" will be equipped with for us gamers!'),
    (4, 'Laptop ASUS ZenBook S13 OLED UX5304VA NQ125Wp', true, 15, 1400.00, 'https://product.hstatic.net/200000722513/product/nq125w_3400c330ee324e9ca3d1415954aee454_fb29d72705fe4980aa1e48c91e12f2ef_master.png', 'One of the most popular high-end gaming laptops today with a special appearance and powerful configuration, this is also the child of the famous Dell brand for office laptops, which is Alienware. Today GEARVN will bring you a Dell Alienware M15 R6 P109F001DBL laptop, let see what the "alien" will be equipped with for us gamers!'),
	(1, 'Laptop gaming Dell G15 5525 R5H085W11GR3050', true, 15, 1400.00, 'https://product.hstatic.net/200000722513/product/aming-dell-g15-5525-r5h085w11gr3050-1_668f40d1e8e740bbbea8e138ca070b70_3cf65dc93ca74d83b6f87c06937eeb2e_master.png', 'One of the most popular high-end gaming laptops today with a special appearance and powerful configuration, this is also the child of the famous Dell brand for office laptops, which is Alienware. Today GEARVN will bring you a Dell Alienware M15 R6 P109F001DBL laptop, let see what the "alien" will be equipped with for us gamers!'),
	(4, 'Laptop gaming ASUS TUF Gaming F15 FX507ZC4 HN095W', true, 15, 1400.00, 'https://product.hstatic.net/200000722513/product/fx507zc4-hn095w_11d5f063040f4a88b599929199c999a6_master.png', 'One of the most popular high-end gaming laptops today with a special appearance and powerful configuration, this is also the child of the famous Dell brand for office laptops, which is Alienware. Today GEARVN will bring you a Dell Alienware M15 R6 P109F001DBL laptop, let see what the "alien" will be equipped with for us gamers!'),
	(3, 'Laptop gaming Acer Nitro 16 Phoenix AN16 41 R50Z', true, 15, 1200.00, 'https://product.hstatic.net/200000722513/product/r50z_93ba4af360724c8ab82d271233a1bfe1_master.png', 'One of the most popular high-end gaming laptops today with a special appearance and powerful configuration, this is also the child of the famous Dell brand for office laptops, which is Alienware. Today GEARVN will bring you a Dell Alienware M15 R6 P109F001DBL laptop, let see what the "alien" will be equipped with for us gamers!'),
	(2, 'MacBook Pro 13 M2 10GPU 8GB 512GB Silver', true, 15, 1600.00, 'https://product.hstatic.net/200000722513/product/book_pro_13_m2_10gpu_8gb_512gb_silver_113e1f0514fc4653b716b53cf19d8f19_fae2cb5eb36a47bd96ab0fccfcd8ae6c_master.jpg', 'One of the most popular high-end gaming laptops today with a special appearance and powerful configuration, this is also the child of the famous Dell brand for office laptops, which is Alienware. Today GEARVN will bring you a Dell Alienware M15 R6 P109F001DBL laptop, let see what the "alien" will be equipped with for us gamers!'),
	(4, 'Laptop Asus VivoBook 15X OLED S3504VA L1226W', true, 15, 1400.00, 'https://product.hstatic.net/200000722513/product/l1226w_7650218a0e6149d7b7330705071f91c5_278df83df576476a8402c94bd5e9406b_master.png', 'One of the most popular high-end gaming laptops today with a special appearance and powerful configuration, this is also the child of the famous Dell brand for office laptops, which is Alienware. Today GEARVN will bring you a Dell Alienware M15 R6 P109F001DBL laptop, let see what the "alien" will be equipped with for us gamers!');

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

INSERT INTO order_detail (order_id, product_id, quantity, price, total) VALUES
	(2, 2, 1, 1800.00, 1800.00);
    
-- ALTER TABLE customer CHANGE createdAt created_at DATETIME;
