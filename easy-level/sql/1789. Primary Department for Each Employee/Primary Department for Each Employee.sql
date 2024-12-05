WITH counts AS (
    SELECT employee_id, COUNT(department_id) AS dep_count
    FROM Employee
    GROUP BY employee_id
),
joined AS (
    SELECT e.employee_id, department_id, primary_flag, dep_count
    FROM Employee e
    JOIN counts c
    ON e.employee_id = c.employee_id
)
SELECT employee_id, department_id
FROM joined
WHERE (dep_count = 1) OR (dep_count > 1 AND primary_flag = 'Y')
ORDER BY employee_id;