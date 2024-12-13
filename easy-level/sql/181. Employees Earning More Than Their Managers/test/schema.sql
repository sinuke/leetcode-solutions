DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
    id INT,
    name VARCHAR(255),
    salary INT,
    managerId INT,
    PRIMARY KEY (id)
);