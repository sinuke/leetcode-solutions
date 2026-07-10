DROP TABLE IF EXISTS patients;
DROP TABLE IF EXISTS covid_tests;

CREATE TABLE patients
(
    patient_id   INT PRIMARY KEY,
    patient_name VARCHAR(100),
    age          INT
);

CREATE TABLE covid_tests
(
    test_id    INT PRIMARY KEY,
    patient_id INT,
    test_date  DATE,
    result     VARCHAR(20)
);
