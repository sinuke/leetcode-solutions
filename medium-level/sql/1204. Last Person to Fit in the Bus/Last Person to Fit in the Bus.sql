WITH calc AS (
    SELECT
        turn,
        person_id,
        person_name,
        weight,
        SUM(weight) OVER (ORDER BY turn) AS total
    FROM Queue
    ORDER BY turn
)
SELECT person_name
FROM calc
WHERE total <= 1000
ORDER BY total DESC
LIMIT 1;