WITH filtered AS (
  SELECT ip
  FROM logs
  WHERE ip NOT REGEXP '^[0-9]*\.[0-9]*\.[0-9]*\.[0-9]*$' OR ip REGEXP '(^|\\.)0[0-9]+' OR ip NOT REGEXP '^(25[0-5]|2[0-4][0-9]|1?[0-9]{1,2}|)(\\.(25[0-5]|2[0-4][0-9]|1?[0-9]{1,2}|)){3}$'
)
SELECT
  ip,
  COUNT(ip) AS invalid_count
FROM filtered
GROUP BY ip
ORDER BY invalid_count DESC, ip DESC;