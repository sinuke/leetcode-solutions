WITH avg_calc AS (
  SELECT
    user_id,
    AVG(CASE WHEN activity_type = 'free_trial' THEN activity_duration END) AS trial_avg_duration,
    AVG(CASE WHEN activity_type = 'paid' THEN activity_duration END) AS paid_avg_duration 
  FROM UserActivity
  GROUP BY user_id
)
SELECT
  user_id,
  ROUND(trial_avg_duration, 2) AS trial_avg_duration,
  ROUND(paid_avg_duration, 2) AS paid_avg_duration
FROM avg_calc
WHERE trial_avg_duration IS NOT NULL AND paid_avg_duration IS NOT NULL
ORDER BY user_id ASC;