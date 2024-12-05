WITH red_id AS (
    SELECT com_id
    FROM Company
    WHERE name = 'RED'
),
not_needed_sales_ids AS (
    SELECT sales_id
    FROM Orders
    WHERE com_id IN (SELECT com_id FROM red_id)
)
SELECT sp.name
FROM SalesPerson sp
WHERE sp.sales_id NOT IN (SELECT sales_id FROM not_needed_sales_ids);