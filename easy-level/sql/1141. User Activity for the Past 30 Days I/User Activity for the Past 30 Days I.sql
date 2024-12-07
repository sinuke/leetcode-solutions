SELECT activity_date AS day, COUNT(user_id) AS active_users
FROM (
    SELECT user_id, activity_date, COUNT(activity_type) AS actions
    FROM Activity
    GROUP BY user_id, activity_date
    HAVING activity_date BETWEEN '2019-06-28' AND '2019-07-27'
) t
GROUP BY activity_date
ORDER BY day ASC;