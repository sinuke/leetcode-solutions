DROP TABLE IF EXISTS Employees;
CREATE TABLE Employees (
    id INT PRIMARY KEY,
    name VARCHAR(255)
);

DROP TABLE IF EXISTS EmployeeUNI;
CREATE  TABLE EmployeeUNI (
    id INT,
    unique_id INT
);