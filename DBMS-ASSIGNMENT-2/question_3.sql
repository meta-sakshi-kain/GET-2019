USE STOREFRONT;

# Recent 50 Orders placed (Id, Order Date, Order Total).
SELECT 
    ORDER_ID, ORDER_DATE, AMOUNT
FROM
    ORDERS
ORDER BY ORDER_ID DESC
LIMIT 50;

#10 most expensive Orders.
SELECT 
    ORDER_ID, ORDER_DATE, AMOUNT
FROM
    ORDERS
ORDER BY AMOUNT DESC
LIMIT 10;

#all the Orders which are placed more than 10 days old and one or
# more items from those orders are still not shipped.
SELECT 
    ORDER_ID, ORDER_DATE, AMOUNT
FROM
    ORDERS
WHERE
    DATEDIFF(CURDATE(), ORDER_DATE) >= 10 AND order_status = 'Not Shipped';

#list of shoppers which haven't ordered anything since last month.
SELECT 
    SHOPPER.SHOPPER_NAME
FROM
    SHOPPER,
    ORDERS
WHERE
    SHOPPER.SHOPPER_ID = ORDERS.SHOPPER_ID AND DATEDIFF(CURDATE(), ORDER_DATE) >= 30;

#list of shopper along with orders placed by them in last 15 days. 
SELECT 
    SHOPPER.SHOPPER_NAME,
    ORDERS.order_id,
    ORDERS.AMOUNT,
    ORDERS.ORDER_STATUS
FROM
    SHOPPER,
    ORDERS
WHERE
    SHOPPER.SHOPPER_ID = ORDERS.SHOPPER_ID AND DATEDIFF(CURDATE(), ORDER_DATE) <= 15;
 
#list of order items which are in “shipped” state for particular Order Id 
SELECT 
    PRODUCT_NAME
FROM
    ITEMS_ORDERED
        INNER JOIN
    ORDERS ON ORDERS.ORDER_ID = ITEMS_ORDERED.ORDER_ID
WHERE
    ORDERS.ORDER_ID = 1 AND ORDERS.ORDER_STATUS = 'Shipped'; 
  
#list of order items along with order placed date which fall between Rs 20000 to Rs 50000 price.
SELECT 
    ITEMS_ORDERED.PRODUCT_NAME, ORDERS.ORDER_DATE
FROM
    ITEMS_ORDERED
        INNER JOIN
    ORDERS ON ORDERS.ORDER_ID = ITEMS_ORDERED.ORDER_ID
WHERE
    ORDERS.AMOUNT BETWEEN 20000 AND 50000;
