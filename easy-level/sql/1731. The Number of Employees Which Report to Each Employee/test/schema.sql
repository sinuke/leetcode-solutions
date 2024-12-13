DROP TABLE IF EXISTS Employees;
CREATE TABLE Employees (
    employee_id INT,
    name VARCHAR(255),
    reports_to INT,
    age INT,
    PRIMARY KEY (employee_id)
);