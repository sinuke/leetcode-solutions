DROP TABLE IF EXISTS sales;
DROP TABLE IF EXISTS products;

CREATE TABLE sales
(
    sale_id    INT PRIMARY KEY,
    product_id INT,
    sale_date  DATE,
    quantity   INT,
    price      DECIMAL(10, 2)
);

CREATE TABLE products
(
    product_id   INT PRIMARY KEY,
    product_name VARCHAR(100),
    category     VARCHAR(100)
);
