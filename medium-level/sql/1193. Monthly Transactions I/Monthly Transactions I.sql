WITH t1 AS (
    SELECT
        id,
        DATE_FORMAT(trans_date, '%Y-%m') AS month,
        country,
        state,
        amount
    FROM Transactions
),
t2 AS (
    SELECT month, country, COUNT(id) AS trans_count, SUM(amount) AS trans_total_amount
    FROM t1
    GROUP BY month, country
),
t3 AS (
    SELECT month, country, COUNT(id) AS approved_count, SUM(amount) AS approved_total_amount
    FROM (SELECT * FROM t1 WHERE state = 'approved') tt
    GROUP BY month, country
)
SELECT t2.month, t2.country, trans_count, COALESCE(approved_count, 0) AS approved_count, trans_total_amount, COALESCE(approved_total_amount, 0) AS approved_total_amount
FROM t2
LEFT JOIN t3
ON t2.month = t3.month AND IFNULL(t2.country, 'xxxx') = IFNULL(t3.country, 'xxxx')
ORDER BY month;