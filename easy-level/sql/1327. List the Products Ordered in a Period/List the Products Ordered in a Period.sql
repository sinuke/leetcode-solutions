WITH filtered AS (
    SELECT product_id, unit
    FROM Orders
    WHERE YEAR(order_date) = 2020 AND MONTH(order_date) = 2
),
counted AS (
    SELECT product_id, SUM(unit) AS cnt
    FROM filtered
    GROUP BY product_id
    HAVING cnt >= 100
)
SELECT product_name, cnt AS unit
FROM Products p
JOIN counted c
ON p.product_id = c.product_id;