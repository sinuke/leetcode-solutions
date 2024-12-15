WITH t0 AS (
    SELECT mr.movie_id, title, mr.user_id, name, rating, created_at
    FROM MovieRating mr
             JOIN Users u
                  ON mr.user_id = u.user_id
             JOIN Movies m
                  ON mr.movie_id = m.movie_id
),
t1 AS (
    SELECT name, COUNT(movie_id) AS cnt
    FROM t0
    GROUP BY user_id, name
    ORDER BY cnt DESC, name
    LIMIT 1
),
t2 AS (
    SELECT title, AVG(rating) AS avg_rating
    FROM (SELECT * FROM t0 WHERE YEAR(created_at) = 2020 AND MONTH(created_at) = 2) t
    GROUP BY movie_id, title
    ORDER BY avg_rating DESC, title
    LIMIT 1
)
SELECT name AS results
FROM t1
UNION ALL
SELECT title AS results
FROM t2;