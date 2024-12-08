WITH ranked AS (
    SELECT player_id, event_date, RANK() OVER (PARTITION BY player_id ORDER BY event_date) AS rnk
    FROM Activity
    ORDER BY player_id, event_date
),
t1 AS (
    SELECT player_id, IFNULL(DATEDIFF(event_date, LAG(event_date) OVER (PARTITION BY player_id ORDER BY event_date)), 0) AS one_day_login
    FROM ranked
    WHERE rnk < 3
),
t2 AS (
    SELECT COUNT(player_id) AS cnt
    FROM t1
    WHERE one_day_login = 1
)
SELECT ROUND((SELECT cnt FROM t2) / COUNT(DISTINCT player_id), 2) AS fraction
FROM Activity;