WITH t1 AS (
    SELECT
        delivery_id,
        CASE WHEN order_date = customer_pref_delivery_date THEN true ELSE false END AS immediate,
        DENSE_RANK() OVER (PARTITION BY customer_id ORDER BY order_date, delivery_id) AS rnk
    FROM Delivery
),
immediate_count AS (
    SELECT COUNT(delivery_id) AS immediate_cnt
    FROM t1
    WHERE rnk = 1 AND immediate = true
),
total_count AS (
    SELECT COUNT(delivery_id) AS total_cnt
    FROM t1
    WHERE rnk = 1
)
SELECT ROUND((immediate_cnt / total_cnt) * 100, 2) AS immediate_percentage
FROM immediate_count, total_count;