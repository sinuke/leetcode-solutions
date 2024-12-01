SELECT name, COALESCE(distance, 0) AS travelled_distance
FROM Users u
LEFT JOIN (
    SELECT user_id, SUM(distance) AS distance
    FROM Rides
    GROUP BY user_id
) r
ON u.id = r.user_id
ORDER BY distance DESC, name ASC;