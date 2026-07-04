CREATE TABLE employees
(
    employee_id   INT PRIMARY KEY,
    employee_name VARCHAR(100),
    department    VARCHAR(100)
);

CREATE TABLE meetings
(
    meeting_id     INT PRIMARY KEY,
    employee_id    INT,
    meeting_date   DATE,
    meeting_type   VARCHAR(20),
    duration_hours DECIMAL(5, 1)
);
