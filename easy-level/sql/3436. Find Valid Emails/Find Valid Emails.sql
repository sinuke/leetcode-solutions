SELECT user_id, email
FROM Users
WHERE email REGEXP '^[A-Za-z0-9_]+@{1}[A-Za-z]+\\.com$'
ORDER BY user_id ASC;