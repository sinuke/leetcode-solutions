WITH seasoned AS (
  SELECT
    sale_id,
    product_id,
    CASE 
      WHEN MONTH(sale_date) IN (3, 4, 5) THEN 'Spring'
      WHEN MONTH(sale_date) IN (6, 7, 8) THEN 'Summer'
      WHEN MONTH(sale_date) IN (9, 10, 11) THEN 'Fall'
      ELSE 'Winter'
    END AS season,
    quantity,
    quantity * price AS revenue
  FROM sales
),
categored AS (
  SELECT
    s.sale_id,
    s.season,
    s.quantity,
    s.revenue,
    p.category
  FROM seasoned s
  JOIN products p
  ON s.product_id = p.product_id
),
grouped AS (
  SELECT
    season,
    category,
    SUM(quantity) AS total_quantity,
    SUM(revenue) AS total_revenue
  FROM categored
  GROUP BY season, category
),
ranked AS (
  SELECT
    g.*,
    ROW_NUMBER() OVER (PARTITION BY season ORDER BY total_quantity DESC, total_revenue DESC, category ASC) AS rn
  FROM grouped g
)
SELECT
  season,
  category,
  total_quantity,
  total_revenue
FROM ranked
WHERE rn = 1
ORDER BY season ASC;