DROP TABLE IF EXISTS Employees;
CREATE TABLE Employees (
    id INT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS EmployeeUNI;
CREATE  TABLE EmployeeUNI (
    id INT,
    unique_id INT
);