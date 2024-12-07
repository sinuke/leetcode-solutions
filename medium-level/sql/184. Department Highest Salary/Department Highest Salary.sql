WITH maxSalaries AS (
    SELECT DISTINCT MAX(salary) OVER (PARTITION BY departmentId) AS maxSalary, departmentId
    FROM Employee
),
maxSalariesWithDepartments AS (
    SELECT t1.departmentId, t2.name, t1.maxSalary
    FROM maxSalaries t1
    JOIN Department t2
    ON t1.departmentId = t2.id
)
SELECT t3.name as Department, t4.name AS Employee, t3.maxSalary AS Salary
FROM maxSalariesWithDepartments t3
JOIN Employee t4
ON t3.departmentId = t4.departmentId AND t3.maxSalary = t4.salary
ORDER BY t3.departmentId;