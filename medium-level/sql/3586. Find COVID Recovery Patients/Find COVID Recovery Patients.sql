WITH pos_flag AS (
  SELECT
    patient_id,
    test_date,
    result,
    MAX(CASE WHEN result = 'Positive' THEN 1 ELSE 0 END) OVER (PARTITION BY patient_id ORDER BY test_date) AS has_positive
    FROM covid_tests
),
pd AS (
  SELECT
    patient_id,
    MIN(test_date) AS pos_date
  FROM pos_flag
  WHERE result = 'Positive'
  GROUP BY patient_id
),
nd AS (
  SELECT
    patient_id,
    MIN(test_date) AS neg_date
  FROM pos_flag
  WHERE result = 'Negative' AND has_positive = 1
  GROUP BY patient_id
),
joined AS (
  SELECT
    pd.patient_id,
    DATEDIFF(nd.neg_date, pd.pos_date) AS recovery_time
  FROM pd
  JOIN nd
  ON pd.patient_id = nd.patient_id
)
SELECT
  j.patient_id,
  p.patient_name,
  p.age,
  j.recovery_time
FROM joined j
JOIN patients p
ON p.patient_id = j.patient_id
ORDER BY recovery_time ASC, patient_name ASC;