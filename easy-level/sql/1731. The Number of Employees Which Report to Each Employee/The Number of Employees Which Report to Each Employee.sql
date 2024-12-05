WITH reports AS (
    SELECT reports_to, COUNT(employee_id) AS reports_count, ROUND(AVG(age), 0) AS average_age
    FROM Employees
    WHERE reports_to IS NOT NULL
    GROUP BY reports_to
)
SELECT e.employee_id, name, reports_count, average_age
FROM reports r
JOIN Employees e
ON r.reports_to = e.employee_id
ORDER BY employee_id;