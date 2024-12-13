DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
    id INT,
    name VARCHAR(255),
    department VARCHAR(255),
    managerId INT,
    PRIMARY KEY (id)
);