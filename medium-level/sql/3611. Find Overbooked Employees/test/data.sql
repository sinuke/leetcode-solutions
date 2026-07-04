INSERT INTO employees (employee_id, employee_name, department) VALUES
(1, 'Alice Johnson', 'Engineering'),
(2, 'Bob Smith', 'Marketing'),
(3, 'Carol Davis', 'Sales'),
(4, 'David Wilson', 'Engineering'),
(5, 'Emma Brown', 'HR');

INSERT INTO meetings (meeting_id, employee_id, meeting_date, meeting_type, duration_hours) VALUES
(1,  1, '2023-06-05', 'Team',     8.0),
(2,  1, '2023-06-06', 'Client',   6.0),
(3,  1, '2023-06-07', 'Training', 7.0),
(4,  1, '2023-06-12', 'Team',     12.0),
(5,  1, '2023-06-13', 'Client',   9.0),
(6,  2, '2023-06-05', 'Team',     15.0),
(7,  2, '2023-06-06', 'Client',   8.0),
(8,  2, '2023-06-12', 'Training', 10.0),
(9,  3, '2023-06-05', 'Team',     4.0),
(10, 3, '2023-06-06', 'Client',   3.0),
(11, 4, '2023-06-05', 'Team',     25.0),
(12, 4, '2023-06-19', 'Client',   22.0),
(13, 5, '2023-06-05', 'Training', 2.0);
