DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
    id INT,
    name VARCHAR(255),
    salary INT,
    departmentId INT,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
    id INT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);