SELECT customer_id, COUNT(visit_id) AS count_no_trans
FROM (
    SELECT customer_id, v.visit_id, transaction_id
    FROM Visits v
    LEFT JOIN Transactions t
    ON v.visit_id = t.visit_id
) tt
WHERE transaction_id IS NULL
GROUP BY customer_id
ORDER BY count_no_trans;