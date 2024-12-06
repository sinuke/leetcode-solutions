WITH joined AS (
    SELECT e.employee_id, name, salary
    FROM Employees e
    LEFT JOIN Salaries s
    ON e.employee_id = s.employee_id
    UNION ALL
    SELECT s.employee_id, name, salary
    FROM Employees e
    RIGHT JOIN Salaries s
    ON e.employee_id = s.employee_id
    WHERE e.employee_id IS NULL
)
SELECT employee_id
FROM joined
WHERE name IS NULL OR salary IS NULL
ORDER BY employee_id;