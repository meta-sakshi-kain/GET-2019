/*Identify the columns require indexing in order, product, category tables and create indexes.*/

ALTER TABLE orders ADD INDEX index_date_of_order(order_date);
ALTER TABLE orders ADD INDEX index_shopper_id(shopper_id);
ALTER TABLE product ADD INDEX index_name(name);
ALTER TABLE categories ADD INDEX index_parent_id(parent_category);
ALTER TABLE categorylink ADD INDEX index_category_id(category_id);
ALTER TABLE categorylink ADD INDEX index_product_id(product_id);
ALTER TABLE items_ordered ADD INDEX index_order_status(order_status);