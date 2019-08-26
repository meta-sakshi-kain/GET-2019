USE storefront;

/*Create a Stored procedure to retrieve total sale in a month*/
DELIMITER $$
CREATE PROCEDURE getTotalAmount(IN m INT,y INT,OUT total_orders INT)
BEGIN 
SELECT 
    (SELECT 
        SUM(items_ordered.total_amount)
    FROM
        items_ordered,
        orders o
    WHERE
        items_ordered.order_id = o.order_id AND MONTH(o.order_date) = m AND YEAR(o.order_date) = y)
INTO TOTAL_ORDERS;
END 
$$

/*Create a Stored procedure to retrieve average sales of each product in a month. Month and year will be input parameter to function.
*/
DELIMITER $$
CREATE PROCEDURE getAverageSales(
IN m INT, y INT)
BEGIN 
 CALL getTotalAmount(7,2019,@T);
 SELECT i.product_id,(SELECT SUM(total_amount) FROM items_ordered ii WHERE ii.order_id = o.order_id 
 AND MONTH(o.order_date) = m 
 AND YEAR(o.order_date) = y 
 GROUP BY i.product_id)/@T AS average_sale
 FROM product,items_ordered i,orders o
 WHERE i.order_id = o.order_id AND MONTH(o.order_date) = m AND YEAR(o.order_date) = y
 GROUP BY i.product_id ;
END 
$$

/*Create a stored procedure to retrieve table having order detail with status for a given period. 
Start date and end date will be input parameter. Put validation on input dates like start date is less than end date.
If start date is greater than end date take first date of month as start date.
*/
Delimiter $$
CREATE PROCEDURE getOrderDetail(IN start_date DATE,end_date DATE)
BEGIN
IF (start_date > end_date)
THEN SET start_date= CONCAT('01',DATE_FORMAT(end_date,'%m-%y'));
END IF;
 SELECT o.order_id,s.shopper_name,o.amount,o.order_date,o.order_status FROM orders o,shopper s WHERE s.shopper_id=o.shopper_id 
 AND o.order_date BETWEEN start_date AND end_date;
 END
 $$
