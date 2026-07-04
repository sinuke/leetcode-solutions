WITH extended AS (
    SELECT
      id,
      visit_date,
      people,
      LEAD(people, 1, 0) OVER(ORDER BY visit_date) AS next1,
      LEAD(people, 2, 0) OVER(ORDER BY visit_date) AS next2,
      LAG(people, 1, 0) OVER(ORDER BY visit_date) AS prev1,
      LAG(people, 2, 0) OVER(ORDER BY visit_date) AS prev2
    FROM Stadium
),
marked AS (
  SELECT
    id,
    visit_date,
    people,
    people >= 100 AND (
        (next1 >= 100 AND next2 >= 100) OR 
        (prev1 >= 100 AND prev2 >= 100) OR 
        (next1 >= 100 AND prev1 >= 100)
    ) AS flag
  FROM extended
)
SELECT
  id,
  visit_date,
  people
FROM marked
WHERE flag = 1
ORDER BY id ASC;