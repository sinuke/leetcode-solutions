DROP TABLE IF EXISTS Product;
CREATE TABLE Product (
    product_id INT,
    product_name VARCHAR(255),
    unit_price INT,
    PRIMARY KEY (product_id)
);

DROP TABLE IF EXISTS Sales;
CREATE TABLE Sales (
    seller_id INT,
    product_id INT,
    buyer_id INT,
    sale_date DATE,
    quantity INT,
    price INT
);