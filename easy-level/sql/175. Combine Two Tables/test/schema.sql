DROP TABLE IF EXISTS Person;
CREATE TABLE Person (
    personId INT,
    lastName VARCHAR(255),
    firstName VARCHAR(255),
    PRIMARY KEY (personId)
);

DROP TABLE IF EXISTS Address;
CREATE TABLE Address (
    addressId INT,
    personId INT,
    city VARCHAR(255),
    state VARCHAR(255),
    PRIMARY KEY (addressId)
);