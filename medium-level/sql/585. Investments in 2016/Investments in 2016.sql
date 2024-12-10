WITH coords AS(
    SELECT pid, tiv_2016, tiv_2015, CONCAT(lat, lon) AS coord
    FROM Insurance
),
count_coords AS (
    SELECT coord, COUNT(pid) AS cnt
    FROM coords
    GROUP BY coord
    ),
unique_coords AS (
    SELECT *
    FROM count_coords
    WHERE cnt = 1
),
tiv_15_counts AS (
    SELECT tiv_2015, COUNT(pid) AS cnt
    FROM Insurance
    GROUP BY tiv_2015
),
tiv_15_counts_filtered AS (
    SELECT *
    FROM tiv_15_counts
    WHERE cnt > 1
),
joined AS (
    SELECT f.tiv_2016, coord
    FROM coords f
    JOIN tiv_15_counts_filtered t
    ON t.tiv_2015 = f.tiv_2015
)
SELECT ROUND(SUM(tiv_2016), 2) AS tiv_2016
FROM joined
WHERE coord IN (SELECT coord FROM unique_coords);