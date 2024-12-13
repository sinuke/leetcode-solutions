WITH t1 AS (
    SELECT product_id, new_price, change_date
    FROM Products
    WHERE change_date <= '2019-08-16'
),
t2 AS (
    SELECT product_id, MAX(change_date) AS change_date
    FROM t1
    GROUP BY product_id
),
t3 AS (
    SELECT t1.product_id, new_price AS price
    FROM t1
    JOIN t2
    ON t1.product_id = t2.product_id AND t1.change_date = t2.change_date
),
t4 AS (
    SELECT DISTINCT product_id, 10 AS price
    FROM Products
    WHERE product_id NOT IN (SELECT product_id FROM t1)
)
SELECT *
FROM t3
UNION ALL
SELECT *
FROM t4
ORDER BY product_id;