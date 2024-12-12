WITH min_years AS (
    SELECT product_id, MIN(year) AS min_year
    FROM Sales
    GROUP BY product_id
),
filtered AS (
    SELECT sale_id, t1.product_id, t1.year, quantity, price
    FROM Sales t1
    JOIN min_years t2
    ON t1.product_id = t2.product_id AND t1.year = t2.min_year
)
SELECT product_id, year AS first_year, SUM(quantity) AS quantity, price
FROM filtered
GROUP BY product_id, year, price
ORDER BY product_id;