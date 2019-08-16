USE StoreFront;

SHOW TABLES;

ALTER TABLE items_ordered DROP FOREIGN KEY product_id;

DROP TABLE Product;

CREATE TABLE Product(
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    quantity INT NOT NULL,
    price DOUBLE NOT NULL,
    image VARCHAR(20),
    category_id INT,
    date DATE NOT NULL,
    FOREIGN KEY (category_id)
        REFERENCES Category (category_id)
);

ALTER TABLE items_ordered ADD CONSTRAINT `product_id` FOREIGN KEY (product_id)
        REFERENCES Product (product_id);