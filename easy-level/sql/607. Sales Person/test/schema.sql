DROP TABLE IF EXISTS SalesPerson;
CREATE TABLE SalesPerson (
    sales_id INT,
    name VARCHAR(255),
    salary INT,
    commission_rate INT,
    hire_date DATE
);

DROP TABLE IF EXISTS Company;
CREATE TABLE Company (
    com_id INT,
    name VARCHAR(255),
    city VARCHAR(255)
);

DROP TABLE IF EXISTS Orders;
CREATE TABLE Orders (
    order_id INT,
    order_date DATE,
    com_id INT,
    sales_id INT,
    amount INT
);