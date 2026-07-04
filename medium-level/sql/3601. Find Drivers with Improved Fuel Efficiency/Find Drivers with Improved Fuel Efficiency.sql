WITH ym AS (
  SELECT
    trip_id,
    driver_id,
    YEAR(trip_date) AS trip_year,
    CASE WHEN MONTH(trip_date) BETWEEN 1 AND 6 THEN 'H1' ELSE 'H2' END AS half_year,
    distance_km / fuel_consumed AS efficiency
  FROM trips
),
grouped AS (
  SELECT
    driver_id,
    trip_year,
    AVG(CASE WHEN half_year = 'H1' THEN efficiency END) AS first_half_avg,
    AVG(CASE WHEN half_year = 'H2' THEN efficiency END) AS second_half_avg
  FROM ym
  GROUP BY driver_id, trip_year
),
improvement AS (
  SELECT
    driver_id,
    trip_year,
    first_half_avg,
    second_half_avg,
    second_half_avg - first_half_avg AS efficiency_improvement
  FROM grouped
  WHERE first_half_avg IS NOT NULL AND second_half_avg IS NOT NULL
  HAVING efficiency_improvement > 0
)
SELECT
  i.driver_id,
  d.driver_name,
  ROUND(i.first_half_avg, 2) AS first_half_avg,
  ROUND(i.second_half_avg, 2) AS second_half_avg,
  ROUND(i.efficiency_improvement, 2) AS efficiency_improvement
FROM improvement i
JOIN drivers d
ON d.driver_id = i.driver_id
ORDER BY efficiency_improvement DESC, driver_name ASC;