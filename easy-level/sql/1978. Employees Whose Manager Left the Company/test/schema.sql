DROP TABLE IF EXISTS Employees;
CREATE TABLE Employees (
    employee_id INT,
    name VARCHAR(255),
    manager_id INT,
    salary INT,
    PRIMARY KEY (employee_id)
);