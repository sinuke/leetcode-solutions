DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
    id INT,
    name VARCHAR(255)
);

DROP TABLE IF EXISTS Rides;
CREATE TABLE Rides (
    id INT,
    user_id INT,
    distance INT
);