DROP TABLE IF EXISTS Delivery;
CREATE TABLE Delivery (
    delivery_id INT,
    customer_id INT,
    order_date DATE,
    customer_pref_delivery_date DATE
);