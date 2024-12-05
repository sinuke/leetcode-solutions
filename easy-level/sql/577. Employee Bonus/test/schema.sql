DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
    empId INT,
    name VARCHAR(255),
    supervisor INT, 
    salary INT
);

DROP TABLE IF EXISTS Bonus;
CREATE TABLE Bonus (
    empId INT,
    bonus INT
);