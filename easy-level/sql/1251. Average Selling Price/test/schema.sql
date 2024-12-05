DROP TABLE IF EXISTS Prices;
CREATE TABLE Prices (
    product_id INT,
    start_date DATE,
    end_date DATE,
    price INT
);

DROP TABLE IF EXISTS UnitsSold;
CREATE TABLE UnitsSold (
    product_id INT,
    purchase_date DATE,
    units INT
);