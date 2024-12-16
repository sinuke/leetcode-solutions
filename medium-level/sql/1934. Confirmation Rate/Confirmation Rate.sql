WITH total_counts AS (
    SELECT user_id, COUNT(action) AS total
    FROM Confirmations
    GROUP BY user_id
),
confirmed_counts AS (
    SELECT user_id, COUNT(action) AS confirmed
    FROM Confirmations
    WHERE action = 'confirmed'
    GROUP BY user_id
),
rates AS (
    SELECT t.user_id, ROUND(COALESCE(c.confirmed, 0) / t.total, 2) AS confirmation_rate
    FROM total_counts t
    LEFT JOIN confirmed_counts c
    ON t.user_id = c.user_id
)
SELECT s.user_id, COALESCE(confirmation_rate, 0) AS confirmation_rate
FROM Signups s
LEFT JOIN rates r
ON s.user_id = r.user_id
ORDER BY user_id;