WITH ranked_salary AS (
    SELECT DISTINCT salary, DENSE_RANK() OVER (ORDER BY salary DESC) as rnk
    FROM Employee
)
SELECT COALESCE((SELECT salary FROM ranked_salary WHERE rnk = 2), NULL) AS SecondHighestSalary;