WITH counts AS (
    SELECT id, num, IF(num = LEAD(num, 1, NULL) OVER (ORDER BY id) AND num = LEAD(num, 2, NULL) OVER (ORDER BY id), '3', '1') AS cnt
    FROM Logs
)
SELECT DISTINCT num AS ConsecutiveNums
FROM counts
WHERE cnt = 3;