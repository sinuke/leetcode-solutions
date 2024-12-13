DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
    user_id INT,
    user_name VARCHAR(255),
    PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS Register;
CREATE TABLE Register (
    contest_id INT,
    user_id INT
);