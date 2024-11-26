SELECT email
FROM (SELECT email, COUNT(id) AS cnt
      FROM Person
      GROUP BY email) aggr
WHERE cnt > 1