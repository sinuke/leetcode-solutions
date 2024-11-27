SELECT e.name AS Employee
FROM (
    SELECT *
    FROM Employee
    WHERE managerId IS NOT NULL
) e
JOIN Employee m ON e.managerId = m.id AND e.salary > m.salary;