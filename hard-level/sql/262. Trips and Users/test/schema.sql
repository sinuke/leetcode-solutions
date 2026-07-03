DROP TABLE IF EXISTS Trips;
CREATE TABLE Trips (
    id INT,
    client_id INT,
    driver_id INT,
    city_id INT,
    status ENUM('completed', 'cancelled_by_driver', 'cancelled_by_client'),
    request_at VARCHAR(10),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
    users_id INT,
    banned ENUM('Yes', 'No'),
    role ENUM('client', 'driver', 'partner'),
    PRIMARY KEY (users_id)
);
