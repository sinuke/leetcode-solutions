DELETE FROM Person
WHERE id NOT IN (
  SELECT * FROM (
    SELECT MIN(Person.id) AS id
    FROM Person
    GROUP BY Person.email
  ) p
);