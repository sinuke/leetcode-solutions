SELECT
  transaction_date,
  SUM(IF(amount IS NULL OR amount % 2 <> 0, amount, 0)) AS odd_sum,
  SUM(IF(amount IS NULL OR amount % 2 = 0, amount, 0)) AS even_sum
FROM transactions
GROUP BY transaction_date
ORDER BY transaction_date;