WITH t1 AS (
    SELECT visited_on, SUM(amount) AS amount
    FROM Customer
    GROUP BY visited_on
),
t2 AS (
    SELECT
        visited_on,
        SUM(amount) OVER w AS amount,
        FIRST_VALUE(visited_on) OVER w AS start_date
    FROM t1
    WINDOW w AS (ORDER BY visited_on RANGE INTERVAL 6 DAY PRECEDING)
)
SELECT MAX(visited_on) AS visited_on, MAX(amount) AS amount, ROUND(MAX(amount) / 7, 2) AS average_amount
FROM t2
GROUP BY start_date
ORDER BY visited_on;