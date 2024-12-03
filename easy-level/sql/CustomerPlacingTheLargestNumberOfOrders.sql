SELECT customer_number
FROM (
    SELECT customer_number, COUNT(order_number) AS cnt
    FROM Orders
    GROUP BY customer_number
    ORDER by cnt DESC
) t 
LIMIT 1;