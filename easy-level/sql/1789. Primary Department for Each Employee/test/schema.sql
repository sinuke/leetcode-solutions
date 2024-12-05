DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
    employee_id INT,
    department_id INT,
    primary_flag ENUM('Y','N')
);