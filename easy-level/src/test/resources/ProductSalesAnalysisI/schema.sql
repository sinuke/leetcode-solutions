DROP TABLE IF EXISTS Sales;
CREATE TABLE Sales (
    sale_id INT,
    product_id int,
    "year" INT,
    quantity INT,
    price INT
);

DROP TABLE IF EXISTS Product;
CREATE TABLE Product (
    product_id INT,
    product_name VARCHAR(255)
);