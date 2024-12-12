SELECT
    id,
    CASE
        WHEN id % 2 <> 0 AND LEAD(id) OVER (ORDER BY id) IS NOT NULL THEN LEAD(student) OVER(ORDER BY id)
        WHEN id % 2 = 0 THEN LAG(student) OVER (ORDER BY id)
        ELSE student
        END AS student
FROM Seat
ORDER BY id;