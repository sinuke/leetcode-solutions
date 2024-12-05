DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    user_name VARCHAR(255)
);

DROP TABLE IF EXISTS Register;
CREATE TABLE Register (
    contest_id INT,
    user_id INT
);