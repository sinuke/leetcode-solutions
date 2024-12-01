WITH temp1 AS (
    SELECT query_name, COUNT(rating) AS total_count, ROUND(AVG(rating / CAST(position AS DOUBLE)), 2) AS quality
    FROM Queries
    GROUP BY query_name
    HAVING query_name IS NOT NULL
),
temp2 AS (
    SELECT query_name, rating
    FROM Queries
    WHERE rating < 3
),
temp3 AS (
    SELECT query_name, COUNT(rating) AS poor_count
    FROM temp2
    GROUP BY query_name
)
SELECT
    t1.query_name,
    t1.quality,
    ROUND((COALESCE(t3.poor_count, 0) / CAST(t1.total_count AS DOUBLE)) * 100, 2) AS poor_query_percentage
FROM temp1 t1
LEFT JOIN temp3 t3
ON t1.query_name = t3.query_name
ORDER BY query_name;