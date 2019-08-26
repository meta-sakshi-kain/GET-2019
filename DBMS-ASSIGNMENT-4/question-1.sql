use storefront;

/*Create a function to calculate number of orders in a month. Month and year will be input parameter to function.
*/
DELIMITER //
CREATE FUNCTION get_no_of_orders(m int, y int) RETURNS int DETERMINISTIC
begin 
declare d int;
select (select COUNT(order_id) from orders where year(order_date) = y and month(order_date) = m) into d;
return d;
end
//
DELIMITER ;

/*Create a function to return month in a year having maximum orders. Year will be input parameter.
*/
CREATE FUNCTION get_month_of_max_orders(y int) RETURNS int DETERMINISTIC 
return (select month(order_date) from orders where year(order_date) = y group by month(order_date) order by count(order_id) limit 1);


