SELECT email
FROM (SELECT email, COUNT(id) AS cnt
      FROM Person
      GROUP BY email) aggr
WHERE cnt > 1;

-- from LeetCode solutions
-- SELECT email
-- FROM Person
-- GROUP BY email
-- HAVING COUNT(email) > 1;