DROP TABLE IF EXISTS Employees;
CREATE TABLE Employees (
    employee_id INT,
    name VARCHAR(255)
);

DROP TABLE IF EXISTS Salaries;
CREATE TABLE Salaries (
    employee_id INT,
    salary INT
);