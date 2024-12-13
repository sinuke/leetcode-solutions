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
    SELECT product_id, new_price, change_date
    FROM Products
    WHERE change_date > '2019-08-16' AND product_id NOT IN (SELECT product_id FROM t1)
),
t5 AS (
    SELECT product_id, MIN(change_date) AS change_date
    FROM t4
    GROUP BY product_id
),
t6 AS (
    SELECT t4.product_id, 10 AS price
    FROM t4
    JOIN t5
    ON t4.product_id = t5.product_id AND t4.change_date = t5.change_date
)
SELECT *
FROM t3
UNION ALL
SELECT *
FROM t6
ORDER BY product_id;