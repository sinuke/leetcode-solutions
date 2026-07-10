DROP TABLE IF EXISTS drivers;
DROP TABLE IF EXISTS trips;

CREATE TABLE drivers
(
    driver_id   INT PRIMARY KEY,
    driver_name VARCHAR(100)
);

CREATE TABLE trips
(
    trip_id       INT PRIMARY KEY,
    driver_id     INT,
    trip_date     DATE,
    distance_km   DECIMAL(8, 1),
    fuel_consumed DECIMAL(8, 1)
);
