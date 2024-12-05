SELECT name AS Customers
FROM Customers
WHERE id NOT IN (SELECT customerId FROM Orders);

-- Bad solution (slow):
-- SELECT name AS Customers
-- FROM (
--     SELECT c.id, c.name, o.customerId
--     FROM Customers AS c
--     LEFT JOIN Orders AS o
--     ON c.id = o.customerId
-- ) j
-- WHERE customerId IS NULL;