CREATE TABLE ProductPurchases
(
    user_id    INT,
    product_id INT,
    quantity   INT,
    PRIMARY KEY (user_id, product_id)
);

CREATE TABLE ProductInfo
(
    product_id INT PRIMARY KEY,
    category   VARCHAR(50),
    price      DECIMAL(10, 2)
);
