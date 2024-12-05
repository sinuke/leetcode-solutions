DROP TABLE IF EXISTS Products;
CREATE TABLE Products (
    product_id INT,
    product_name VARCHAR(255),
    product_category VARCHAR(255)
);

DROP TABLE IF EXISTS Orders;
CREATE TABLE Orders (
    product_id INT,
    order_date DATE,
    unit INT
);