INSERT INTO patients (patient_id, patient_name, age) VALUES
(1, 'Alice Smith',  28),
(2, 'Bob Johnson',  35),
(3, 'Carol Davis',  42),
(4, 'David Wilson', 31),
(5, 'Emma Brown',   29);

INSERT INTO covid_tests (test_id, patient_id, test_date, result) VALUES
(1,  1, '2023-01-15', 'Positive'),
(2,  1, '2023-01-25', 'Negative'),
(3,  2, '2023-02-01', 'Positive'),
(4,  2, '2023-02-05', 'Inconclusive'),
(5,  2, '2023-02-12', 'Negative'),
(6,  3, '2023-01-20', 'Negative'),
(7,  3, '2023-02-10', 'Positive'),
(8,  3, '2023-02-20', 'Negative'),
(9,  4, '2023-01-10', 'Positive'),
(10, 4, '2023-01-18', 'Positive'),
(11, 5, '2023-02-15', 'Negative'),
(12, 5, '2023-02-20', 'Negative');
