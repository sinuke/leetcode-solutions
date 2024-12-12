DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
    user_id INT,
    join_date DATE,
    favorite_brand VARCHAR(255)
);

DROP TABLE IF EXISTS Orders;
CREATE TABLE Orders (
    order_id INT,
    order_date DATE,
    item_id INT,
    buyer_id INT,
    seller_id INT
);

DROP TABLE IF EXISTS Items;
CREATE TABLE Items (
    item_id INT,
    item_brand VARCHAR(255)
);