WITH grouped AS (
    SELECT
        student_id,
        subject,
        MIN(exam_date) AS first_date,
        MAX(exam_date) AS last_date
    FROM Scores
    GROUP BY student_id, subject
    HAVING first_date <> last_date
),
fscore AS (
  SELECT
    g.student_id,
    g.subject,
    g.first_date,
    g.last_date,
    s.score AS first_score
  FROM Scores s
  JOIN grouped g
  ON s.student_id = g.student_id AND s.subject = g.subject AND s.exam_date = g.first_date
),
lscore AS (
  SELECT
    f.student_id,
    f.subject,
    f.first_date,
    f.last_date,
    f.first_score,
    s.score AS latest_score
  FROM Scores s
  JOIN fscore f
  ON s.student_id = f.student_id AND s.subject = f.subject AND s.exam_date = f.last_date
)
SELECT 
  student_id,
  subject,
  first_score,
  latest_score
FROM lscore
WHERE latest_score > first_score
ORDER BY student_id ASC, subject ASC;