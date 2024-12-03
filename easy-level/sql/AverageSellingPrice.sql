WITH joined AS (
    SELECT p.product_id, price, COALESCE(units, 0) AS units
    FROM Prices p
    LEFT JOIN UnitsSold s
    ON p.product_id = s.product_id AND s.purchase_date BETWEEN p.start_date AND p.end_date
)
SELECT product_id, COALESCE(ROUND(SUM(price * units) / CAST(SUM(units) AS DOUBLE), 2), 0) AS average_price
FROM joined
GROUP BY product_id;