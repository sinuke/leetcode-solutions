SELECT teacher_id, SUM(cnt) AS cnt
FROM (
    SELECT teacher_id, COUNT(DISTINCT subject_id) AS cnt
    FROM Teacher
    GROUP BY teacher_id, subject_id
) t
GROUP BY teacher_id
ORDER BY teacher_id;