WITH counts AS (
    SELECT managerId, COUNT(*) AS cnt
    FROM Employee
    WHERE managerId IS NOT NULL
    GROUP BY managerId
),
five_counts AS (
    SELECT managerId
    FROM counts
    WHERE cnt >= 5
)
SELECT name
FROM Employee e
JOIN five_counts c
ON e.id = c.managerId
ORDER BY name;