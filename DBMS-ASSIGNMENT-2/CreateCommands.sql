DROP DATABASE STOREFRONT;

CREATE DATABASE StoreFront;
USE StoreFront;

CREATE TABLE User(
    email VARCHAR(30) PRIMARY KEY,
    password VARCHAR(15) NOT NULL,
    name VARCHAR(30) NOT NULL,
    type VARCHAR(1) NOT NULL CHECK (type IN ('A','S')),
    phone_no VARCHAR(10) NOT NULL,
    dob DATE
);
                                                      
CREATE TABLE Admin(
    admin_Id VARCHAR(10) PRIMARY KEY,
    email VARCHAR(30),
    FOREIGN KEY (email)
        REFERENCES User (email)
);
                            
CREATE TABLE Shopper(
    shopper_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(30),
    shopper_name VARCHAR(30),
    FOREIGN KEY (email)
        REFERENCES User (email)
);
                            
CREATE TABLE Address(
    street VARCHAR(30) NOT NULL,
    city VARCHAR(20) NOT NULL,
    state VARCHAR(20) NOT NULL,
    country VARCHAR(20) DEFAULT 'India',
    address_id INT AUTO_INCREMENT PRIMARY KEY,
    pincode VARCHAR(10) NOT NULL,
    shopper_id INT,
    FOREIGN KEY (shopper_id)
        REFERENCES Shopper (shopper_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);
        
CREATE TABLE Category(
    parent_category INT,
    name VARCHAR(20) NOT NULL,
    category_id INT AUTO_INCREMENT PRIMARY KEY
);
        
CREATE TABLE Product(
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    price DOUBLE NOT NULL,
    image VARCHAR(20),
    category_id INT,
    date DATE NOT NULL,
    FOREIGN KEY (category_id)
        REFERENCES Category (category_id)
);
CREATE TABLE categoryproductlink(
    product_id INT,
    category_id INT,
    PRIMARY KEY (product_id,category_id),
    CONSTRAINT Product_Id4 FOREIGN KEY (product_id)
        REFERENCES product (product_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (category_id)
        REFERENCES category (category_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);
        
CREATE TABLE items_ordered(
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    product_name VARCHAR(30),
    product_quantity INT,
    shopper_id INT,
    total_amount DOUBLE,
    FOREIGN KEY (shopper_id)
        REFERENCES Shopper (shopper_id),
    CONSTRAINT product_id FOREIGN KEY (product_id)
        REFERENCES Product (product_id)
);
          
CREATE TABLE orders(
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    amount DOUBLE,
    shopper_id INT,
    order_date DATE,
    order_status VARCHAR(20) CHECK (order_status IN ('Shipped','Cancelled', 'Returned', 'Not Shipped'))
);

CREATE TABLE inventory(
    inventory_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    quantity_in_stock INT,
    CONSTRAINT product_id1 FOREIGN KEY (product_id)
        REFERENCES Product (product_id)
);

        
