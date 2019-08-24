USE StoreFront;

/*
*display all the table names present in StoreFront.
*/
SHOW TABLES;

ALTER TABLE CategoryProductLink DROP FOREIGN KEY Product_Id1;

ALTER TABLE stock DROP FOREIGN KEY Product_Id2;

ALTER TABLE items_ordered DROP FOREIGN KEY product_id3;

ALTER TABLE images DROP FOREIGN KEY Product_Id4;

/*
*remove Product table of the StoreFront database.
*/
DROP TABLE Product;

/*
*Create the Product table again.
*/
CREATE TABLE Product(
    product_id INT AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    quantity INT NOT NULL,
    price DOUBLE NOT NULL,
    category_id INT,
    date DATE NOT NULL,
    PRIMARY KEY (product_id),
    FOREIGN KEY (category_id)
        REFERENCES Category (category_id)
);


ALTER TABLE stock
   ADD CONSTRAINT Product_Id1 FOREIGN KEY ( product_Id) REFERENCES Product( product_Id);

ALTER TABLE stock
   ADD CONSTRAINT Product_Id2 FOREIGN KEY ( product_Id) REFERENCES Product( product_Id);


ALTER TABLE items_ordered 
   ADD CONSTRAINT product_id3 FOREIGN KEY (product_id) REFERENCES Product (product_id);
   
   
ALTER TABLE images
   ADD CONSTRAINT Product_Id4 FOREIGN KEY ( product_Id) REFERENCES Product( product_Id);