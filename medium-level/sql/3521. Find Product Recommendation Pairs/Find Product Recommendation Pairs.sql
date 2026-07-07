WITH products AS (
  SELECT
    product_id
  FROM ProductInfo
  GROUP BY product_id
),
pairs AS (
  SELECT
    p1.product_id AS product1_id,
    p2.product_id AS product2_id
  FROM products p1
  JOIN products p2
  ON p1.product_id < p2.product_id  
),
counted AS (
  SELECT
    pr.product1_id,
    pr.product2_id,   
    COUNT(DISTINCT p1.user_id) AS customer_count
  FROM pairs pr
  JOIN ProductPurchases p1
  ON pr.product1_id = p1.product_id
  JOIN ProductPurchases p2
  ON pr.product2_id = p2.product_id AND p1.user_id = p2.user_id
  GROUP BY pr.product1_id, pr.product2_id
)
SELECT
  c.product1_id,
  c.product2_id,
  p1.category AS product1_category,
  p2.category AS product2_category,
  c.customer_count
FROM counted c
JOIN ProductInfo p1
ON c.product1_id = p1.product_id
JOIN ProductInfo p2
ON c.product2_id = p2.product_id
WHERE customer_count >= 3
ORDER BY customer_count DESC, product1_id ASC, product2_id ASC;