WITH diffs_per_process AS (
    SELECT machine_id, process_id, SUM(CASE WHEN activity_type = 'end' THEN timestamp ELSE -timestamp END) as diff
    FROM Activity
    GROUP BY machine_id, process_id
)
SELECT machine_id, ROUND(AVG(diff), 3) AS processing_time
FROM diffs_per_process
GROUP BY machine_id;