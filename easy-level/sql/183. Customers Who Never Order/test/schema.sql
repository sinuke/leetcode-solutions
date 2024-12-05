DROP TABLE IF EXISTS Customers;
CREATE TABLE Customers (
    id INT PRIMARY KEY,
    name VARCHAR(255)
);

DROP TABLE IF EXISTS Orders;
CREATE TABLE Orders (
    id INT PRIMARY KEY,
    customerId INT
);