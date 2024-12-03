DROP TABLE IF EXISTS Activity;
CREATE TABLE Activity (
    machine_id INT,
    process_id INT,
    activity_type ENUM('start', 'end'),
    timestamp FLOAT
);