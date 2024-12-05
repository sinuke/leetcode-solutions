-- My solution submitted to LeetCode with 62% in Speed:
WITH unique_values AS (
    SELECT DISTINCT sell_date, product
    FROM Activities
    ORDER BY sell_date
)
SELECT sell_date, COUNT(product) AS num_sold, GROUP_CONCAT(product ORDER BY product) AS products
FROM unique_values
GROUP BY sell_date;

-- Solution from LeetCode with good performance (91%):
-- SELECT
--     sell_date,
--     COUNT(DISTINCT product) AS num_sold,
--     GROUP_CONCAT(DISTINCT product ORDER BY product ASC) AS products
-- FROM Activities
-- GROUP BY sell_date
-- ORDER BY sell_date;