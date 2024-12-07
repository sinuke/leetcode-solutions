DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    salary INT,
    departmentId INT
);

DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
    id INT PRIMARY KEY,
    name VARCHAR(255)
);