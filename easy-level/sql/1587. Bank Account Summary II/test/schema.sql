DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
    account INT PRIMARY KEY,
    name VARCHAR(255)
);

DROP TABLE IF EXISTS Transactions;
CREATE TABLE Transactions (
    trans_id INT PRIMARY KEY,
    account INT,
    amount INT,
    transacted_on DATE
);