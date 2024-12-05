WITH users_count AS (
    SELECT COUNT(user_id) AS cnt
    FROM Users
),
aggregated AS (
    SELECT contest_id, COUNT(user_id) AS reg_users
    FROM Register
    GROUP BY contest_id
)
SELECT
    contest_id,
    ROUND((reg_users / CAST((SELECT cnt FROM users_count) AS DOUBLE)) * 100, 2) as percentage
FROM aggregated
ORDER BY percentage DESC, contest_id ASC;