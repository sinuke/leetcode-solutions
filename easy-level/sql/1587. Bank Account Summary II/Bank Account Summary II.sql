SELECT name, balance
FROM Users u
JOIN (
    SELECT account, SUM(amount) AS balance
    FROM Transactions
    GROUP BY account
    HAVING balance > 10000
) t
ON u.account = t.account;