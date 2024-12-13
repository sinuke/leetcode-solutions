DROP TABLE IF EXISTS Products;
CREATE TABLE Products (
    product_id INT,
    low_fats ENUM('Y', 'N'),
    recyclable ENUM('Y', 'N'),
    PRIMARY KEY (product_id)
);