WITH ranked AS (
    SELECT DISTINCT departmentId, salary, DENSE_RANK() OVER (PARTITION BY departmentId ORDER BY salary DESC) AS rnk
    FROM Employee
),
joined1 AS (
    SELECT t1.departmentId, t2.name, t1.salary
    FROM (SELECT * FROM ranked WHERE rnk <= 3) AS t1
    JOIN Department t2
    ON t1.departmentId = t2.id
)
SELECT t3.name AS Department, t4.name AS Employee, t3.salary AS Salary
FROM Employee t4
JOIN joined1 t3
ON t3.departmentId = t4.departmentId AND t3.salary = t4.salary
ORDER BY Department, Salary DESC;