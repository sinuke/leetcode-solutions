WITH weeked AS (
  SELECT
    meeting_id,
    employee_id,
    meeting_date,
    YEARWEEK(meeting_date, 3) AS week,
    duration_hours
  FROM meetings
),
calc_hours AS (
  SELECT
    employee_id,
    week,
    SUM(duration_hours) AS hours_per_week
  FROM weeked
  GROUP BY employee_id, week
  HAVING hours_per_week > 20
),
heavy_weeks AS (
  SELECT
    employee_id,
    COUNT(week) AS meeting_heavy_weeks
  FROM calc_hours
  GROUP BY employee_id
  HAVING meeting_heavy_weeks >= 2
)
SELECT 
  hw.employee_id,
  e.employee_name,
  e.department,
  hw.meeting_heavy_weeks
FROM heavy_weeks hw
JOIN employees e
ON hw.employee_id = e.employee_id
ORDER BY meeting_heavy_weeks DESC, employee_name ASC;