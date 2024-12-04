DROP TABLE IF EXISTS Products;
CREATE TABLE Products (
    product_id INT PRIMARY KEY,
    low_fats ENUM('Y', 'N'),
    recyclable ENUM('Y', 'N')
);