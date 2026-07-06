WITH ranked AS (
  SELECT
    pr.*,
    ROW_NUMBER() OVER (PARTITION BY employee_id ORDER BY review_date DESC) AS rn
  FROM performance_reviews pr
),
gr AS (
  SELECT
    employee_id,
    MAX(CASE WHEN rn = 1 THEN rating END) AS r1,
    MAX(CASE WHEN rn = 2 THEN rating END) AS r2,
    MAX(CASE WHEN rn = 3 THEN rating END) AS r3
  FROM ranked
  WHERE rn <= 3
  GROUP BY employee_id
),
scored AS (
  SELECT
    employee_id,
    r1 - r3 AS improvement_score
  FROM gr
  WHERE r1 IS NOT NULL AND r2 IS NOT NULL AND r3 IS NOT NULL AND r1 > r2 AND r2 > r3
)
SELECT 
  s.employee_id,
  e.name,
  s.improvement_score
FROM scored s
JOIN employees e
ON s.employee_id = e.employee_id
ORDER BY improvement_score DESC, name ASC;