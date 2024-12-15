DROP TABLE IF EXISTS Stocks;
CREATE TABLE Stocks (
    stock_name VARCHAR(15),
    operation ENUM('Sell', 'Buy'),
    operation_day INT,
    price INT
);