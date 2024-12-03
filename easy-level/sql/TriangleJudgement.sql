-- SUBMITTED SOLUTION
-- SELECT x, y, z, IF(x + y > z AND x + z > y AND y + z > x, 'Yes', 'No') AS triangle
-- FROM Triangle;

-- SOLUTION FOR UNIT TESTS (H2 DATABASE LIMITATIONS)
SELECT x, y, z, CASE WHEN x + y > z AND x + z > y AND y + z > x THEN 'Yes' ELSE 'No' END as triangle
FROM Triangle;