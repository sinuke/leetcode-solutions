WITH cats AS (
  SELECT
    category
  FROM ProductInfo
  GROUP BY category
),
paired AS (
  SELECT
    c1.category AS category1,
    c2.category AS category2
  FROM cats c1
  JOIN cats c2
  ON c1.category < c2.category 
),
purchases AS (
  SELECT
    p.user_id,
    i.category
  FROM ProductPurchases p
  JOIN ProductInfo i
  ON p.product_id = i.product_id
),
counted AS (
  SELECT 
    pr.category1,
    pr.category2,
    COUNT(DISTINCT p1.user_id) AS customer_count
  FROM paired pr
  JOIN purchases p1
  ON p1.category = pr.category1
  JOIN purchases p2
  ON p2.category = pr.category2 AND p2.user_id = p1.user_id
  GROUP BY pr.category1, pr.category2
)
SELECT
  category1,
  category2,
  customer_count
FROM counted
WHERE customer_count >= 3
ORDER BY customer_count DESC, category1 ASC, category2 ASC;