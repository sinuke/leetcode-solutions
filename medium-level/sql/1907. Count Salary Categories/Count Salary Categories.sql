WITH salary_low AS (
    SELECT COUNT(account_id) AS accounts_count
    FROM Accounts
    WHERE income < 20000
),
salary_avg AS (
    SELECT COUNT(account_id) AS accounts_count
    FROM Accounts
    WHERE income >= 20000 AND income <= 50000
),
salary_high AS (
    SELECT COUNT(account_id) AS accounts_count
    FROM Accounts
    WHERE income > 50000
)
SELECT 'Low Salary' AS category, accounts_count
FROM salary_low
UNION ALL
SELECT 'Average Salary' AS category, accounts_count
FROM salary_avg
UNION ALL
SELECT 'High Salary' AS category, accounts_count
FROM salary_high;