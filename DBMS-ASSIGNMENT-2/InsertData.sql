USE Storefront;

INSERT INTO user(email,name,phone_no,password,dob,type) VALUES
  ('rsbhatra98@gmail.com', 'rahul sharma', '8947804883', '1234', '1997-10-25', 'A'),
	('rs98@gmail.com', 'rahul jangid', '8947804889', '123412', '1998-10-25', 'S'),
	('chirag10march@gmail.com', 'chirag jain', '7737596610', '12342742', '1997-03-10', 'S'),
	('tanumittal@gmail.com', 'tanu mittal', '1234567893', '4321', '1995-03-31', 'S'),
	('sakshi.kain@gmail.com', 'SAKSHI KAIN', '7877235269', 'asjkfh', '1997-12-25', 'S'),
	('sachingidwani23@gmail.com', 'sachin gidwani', '9878654512', 'adress', '1996-09-22', 'S');
    
INSERT INTO Shopper(email, shopper_name) SELECT email, name FROM user WHERE type='S';

INSERT INTO address (street, city, state, country, pincode, shopper_id) VALUES
	('plot no. 605', 'jaipur', 'rajasthan', 'india', '302039', '3'),
	('MBM HOSTEL', 'JODHPUR', 'rajasthan', 'india', '342011', '3'),
	('JUHU BEACH', 'GOA', 'GOA', 'india', '393231', '2'),
	('NEAR GANESH MANDIR', 'jaipur', 'rajasthan', 'india', '302031', '3'),
	('HALDI GHATI MARG', 'jaipur', 'rajasthan', 'india', '302001', '3'),
	('UDAPURIA', 'UDAIPUR', 'rajasthan', 'india', '382001', '3'),
	('RAM MARG', 'JAISALMAIR', 'rajasthan', 'india', '339401', '3'),
	('RANA SANGA MARG', 'HALDI GHATI', 'PRATAP NAGAR', 'india', '339401', '4'),
	('BAPU NAGAR', 'JAIPUR', 'rajasthan', 'india', '302013', '4');

INSERT INTO category(name,Parent_category) VALUES
 ('Electronics', NULL),
    ('Accessories', NULL),
    ('Fashion Styling', NULL),
    ('Mobile', 1),
    ('Laptop', 1),
    ('USB', 1),
    ('Redmi', 4),
    ('Intex', 4),
    ('Dell', 5),
    ('Sony', 5),
    ('Kingston', 6),
    ('HP', 6),
    ('Watch', 2),
    ('Fastrack', 13),
    ('Timex', 13),
    ('Shirt', 3),
    ('Trouser', 3),
    ('Suit', 3),
    ('Van Heusen', 16),
    ('Van Heusen', 17),
    ('Peter England', 18);

INSERT INTO product(name, price, date,category_id,image) VALUES
    ('Redmi 3s Prime', 9000.00, '2016/07/01',4,'Image.png'),
    ('Redmi Note 4',  12499.99, '2017/08/01',4,NULL),
    ('Dell Inspiron 4Ti6xy', 40000.00, '2018/07/01',5,NULL),
    ('Sony Vostro Glide', 90399.99, '2017/01/01',5,NULL),
    ('Dell Inspiron 5Ti3fa', 50000.00, '2017/09/23',5,NULL),
    ('Kingston 16GB',  900.00, '2016/12/12',6,NULL),
    ('HP 64Gb', 2000.00, '2018/08/01',6,NULL),
    ('Fastrack Digital Watch 4hy7e',  2000.00, '2016/12/01',13,NULL),
    ('Timex Analog Watch', 5000.00, '2018/01/01',13,NULL),
    ('Van Heusen Shirt', 1500.00, '2017/11/11',3,NULL),
    ('Van Heusen Trouser', 2000.00, '2016/07/01',3,NULL),
    ('Peter England Suit', 10000.00, '2014/02/12',3,NULL);
    
INSERT INTO CategoryProductLink(product_id,category_id) VALUES
(1,1),(1,4),(1,7),
(2,1),(2,4),(2,7),
(3,1),(3,5),(3,9),
(4,1),(4,5),(4,10),
(5,1),(5,5),(5,9),
(6,2),(6,11),
(7,2),(7,12),
(8,3),(8,13),(8,14),
(9,3),(9,13),(9,15),
(10,3),(10,16),(10,19),
(11,3),(11,17),(11,19),
(12,3),(12,18),(12,20);

    
INSERT INTO inventory(product_id,quantity_in_stock) VALUES
    (1,50),
    (2,150),
    (3,1),
    (4,10),
    (9,61),
    (6,11),
    (8,12);
    
    
INSERT INTO items_ordered(product_id,product_quantity,shopper_id)  VALUES 
    (1,2,2),
    (2,1,2),
    (4,4,3),
    (2,5,5),
    (9,10,1);
    
UPDATE items_ordered INNER JOIN product ON items_ordered.product_id = product.product_id INNER JOIN inventory  I ON I.product_id=product.product_id
    SET items_ordered.total_amount = product.price * items_ordered.product_quantity, items_ordered.PRODUCT_NAME = PRODUCT.NAME,
    i.quantity_in_stock= i.quantity_in_stock - items_ordered.product_quantity
    WHERE items_ordered.product_QUANTITY < I.quantity_in_stock;
    
DELETE FROM ITEMS_ORDERED WHERE TOTAL_AMOUNT=NULL;

INSERT INTO Orders(ORDER_DATE,ORDER_STATUS)VALUES
(STR_TO_DATE('08-05-2019', '%d-%m-%Y'),'SHIPPED'),
(STR_TO_DATE('28-07-2019','%d-%m-%Y'),'CANCELLED'),
(STR_TO_DATE('15-06-2019','%d-%m-%Y'),'Returned'),
(STR_TO_DATE('23-07-2019','%d-%m-%Y'),'Not Shipped'),
(STR_TO_DATE('11-08-2019','%d-%m-%Y'),'SHIPPED'),
(STR_TO_DATE('30-07-2019','%d-%m-%Y'),'Returned');

    
UPDATE ORDERS INNER JOIN ITEMS_ORDERED ON ORDERS.ORDER_ID = ITEMS_ORDERED.ORDER_ID
    SET ORDERS.SHOPPER_ID = ITEMS_ORDERED.SHOPPER_ID, ORDERS.AMOUNT = ITEMS_ORDERED.total_amount WHERE items_ordered.SHOPPER_ID>0;
    

    
