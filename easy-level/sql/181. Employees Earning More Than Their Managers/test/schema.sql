DROP TABLE Employee IF EXISTS;
CREATE TABLE Employee (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    salary INT,
    managerId INT
);