DROP TABLE IF EXISTS Project;
CREATE TABLE Project (
    project_id INT,
    employee_id INT
);

DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
    employee_id INT,
    name VARCHAR(255),
    experience_years INT,
    PRIMARY KEY (employee_id)
);