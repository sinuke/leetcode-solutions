DROP TABLE IF EXISTS Customers;
CREATE TABLE Customers (
    id INT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Orders;
CREATE TABLE Orders (
    id INT,
    customerId INT,
    PRIMARY KEY (id)
);