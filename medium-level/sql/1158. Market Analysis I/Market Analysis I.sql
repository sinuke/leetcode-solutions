WITH orders_2019 AS (
    SELECT *
    FROM Orders
    WHERE YEAR(order_date) = 2019
),
joined AS (
    SELECT t1.user_id AS buyer_id, t1.join_date, t2.order_id
    FROM Users t1
    LEFT JOIN orders_2019 t2
    ON t2.buyer_id = t1.user_id
)
SELECT buyer_id, join_date, COALESCE(COUNT(order_id), 0) AS orders_in_2019
FROM joined
GROUP BY buyer_id, join_date
ORDER BY buyer_id;