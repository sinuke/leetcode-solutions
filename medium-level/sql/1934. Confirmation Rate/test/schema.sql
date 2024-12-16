DROP TABLE IF EXISTS Signups;
CREATE TABLE Signups (
    user_id INT,
    time_stamp DATE,
    PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS Confirmations;
CREATE TABLE Confirmations (
    user_id INT,
    time_stamp DATETIME,
    action ENUM('confirmed', 'timeout')
);