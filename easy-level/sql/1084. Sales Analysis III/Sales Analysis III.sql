WITH aggregated AS (
    SELECT product_id, GROUP_CONCAT(first_qarter) AS quarters
    FROM (
        SELECT product_id, sale_date BETWEEN '2019-01-01' AND '2019-03-31' AS first_qarter
        FROM Sales
    ) t
    GROUP BY product_id
    HAVING quarters NOT LIKE '%0%'
)
SELECT p.product_id, product_name
FROM Product p
JOIN aggregated a
ON p.product_id = a.product_id;