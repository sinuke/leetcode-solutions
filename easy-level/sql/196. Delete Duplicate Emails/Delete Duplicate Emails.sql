DELETE FROM Person
WHERE id NOT IN (
  SELECT * FROM (
    SELECT MIN(Person.id) AS id
    FROM Person
    GROUP BY Person.email
  ) p
);

-- The following query is not a part of solution. Just needed to verify the result in tests.
SELECT * FROM Person;