WITH count1 AS (
    SELECT requester_id AS id, COUNT(accept_date) AS num
    FROM RequestAccepted
    GROUP BY requester_id
),
count2 AS (
    SELECT accepter_id AS id, COUNT(accept_date) AS num
    FROM RequestAccepted
    GROUP BY accepter_id
),
united AS (
    SELECT id, num
    FROM count1
    UNION ALL
    SELECT id, num
    FROM count2
),
total AS (
    SELECT id, SUM(num) AS num
    FROM united
    GROUP BY id
)
SELECT *
FROM total
ORDER BY num DESC
LIMIT 1;