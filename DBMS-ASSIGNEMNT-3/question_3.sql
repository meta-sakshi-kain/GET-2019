use storefront;
#Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT 
    s.shopper_Id, s.email, COUNT(o.order_id)
FROM
    shopper s
        LEFT JOIN
    orders o ON s.shopper_id = o.shopper_id
WHERE
    DATEDIFF(CURDATE(), ORDER_DATE) > 30
GROUP BY o.shopper_id;


#Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT 
    o.shopper_id, s.email, s.SHOPPER_name
FROM
    orders o
        LEFT JOIN
    shopper s ON o.shopper_id = s.shopper_Id
WHERE
      DATEDIFF(CURDATE(), ORDER_DATE) > 30
ORDER BY o.amount DESC
LIMIT 10;

#Display top 20 Products which are ordered most in last 60 days along with numbers
SELECT 
    p.product_id, p.name, SUM(o.product_quantity) AS numberOfProducts
FROM
    product p,
    items_ordered o
    where o.product_id = p.product_id AND  DATEDIFF(CURDATE(), ORDER_DATE) < 60 
GROUP BY o.product_id
ORDER BY SUM(o.product_quantity) DESC
LIMIT 20;

#Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT 
    MONTH(order_date), SUM(o.amount) AS revenue
FROM
    orders o
WHERE
      DATEDIFF(CURDATE(), ORDER_DATE) > 30
GROUP BY MONTH(order_date); 

#Mark the products as Inactive which are not ordered in last 90 days.
 

#Given a category search keyword, display all the Products present in this category/categories.
SELECT 
    p.product_id, p.name
FROM
    product p,
    category c,
    categoryproductLink cl
WHERE
    c.name LIKE 'mobile'
        AND cl.product_id = p.product_id
        AND c.category_id = cl.category_id;
        
#Display top 10 Items which were cancelled most.
SELECT 
    p.product_id, p.name
FROM
    product p,
    items_ordered c,
    orders 
WHERE
    p.product_id = c.product_id
        AND orders.order_status = 'cancelled'
        AND orders.amount= c.total_amount
GROUP BY c.product_id
ORDER BY COUNT(c.product_id) DESC
LIMIT 10;
