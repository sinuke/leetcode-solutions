WITH t1 AS (
    SELECT customer_id, GROUP_CONCAT(DISTINCT product_key ORDER BY product_key) AS products
    FROM Customer
    GROUP BY customer_id
),
t2 AS (
    SELECT GROUP_CONCAT(DISTINCT product_key ORDER BY product_key) AS products
    FROM Product
)
SELECT customer_id
FROM t1
JOIN t2
ON t1.products = t2.products
ORDER BY customer_id;