SELECT stock_name, SUM(price) AS capital_gain_loss
FROM (SELECT stock_name, IF(operation = 'Buy', -price, price) AS price FROM Stocks) t
GROUP BY stock_name
ORDER BY stock_name;