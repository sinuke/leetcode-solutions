INSERT INTO ProductPurchases (user_id, product_id, quantity)
VALUES (1, 101, 2),
       (1, 102, 1),
       (1, 103, 3),
       (2, 101, 1),
       (2, 102, 5),
       (2, 104, 1),
       (3, 101, 2),
       (3, 103, 1),
       (3, 105, 4),
       (4, 101, 1),
       (4, 102, 1),
       (4, 103, 2),
       (4, 104, 3),
       (5, 102, 2),
       (5, 104, 1);

INSERT INTO ProductInfo (product_id, category, price)
VALUES (101, 'Electronics', 100),
       (102, 'Books', 20),
       (103, 'Clothing', 35),
       (104, 'Kitchen', 50),
       (105, 'Sports', 75);
