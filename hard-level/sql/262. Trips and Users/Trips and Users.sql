WITH unbanned AS (
  SELECT users_id
  FROM Users
  WHERE banned = 'No'
),
filtered AS (
  SELECT *
  FROM Trips
  WHERE request_at IN ('2013-10-01', '2013-10-02', '2013-10-03') AND client_id IN (SELECT users_id FROM unbanned) AND driver_id IN (SELECT users_id FROM unbanned)
),
cancelled AS (
  SELECT request_at, COUNT(status) AS cancelled_cnt
  FROM filtered
  WHERE status = 'cancelled_by_driver' OR status = 'cancelled_by_client'
  GROUP BY request_at
),
total AS (
  SELECT request_at, COUNT(status) AS total_cnt
  FROM filtered
  GROUP BY request_at
)
SELECT t.request_at AS 'Day', ROUND(COALESCE(c.cancelled_cnt, 0) / t.total_cnt, 2) AS 'Cancellation Rate'
FROM total AS t
LEFT JOIN cancelled AS c
ON t.request_at = c.request_at;