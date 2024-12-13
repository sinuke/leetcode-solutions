DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
    account INT,
    name VARCHAR(255),
    PRIMARY KEY (account)
);

DROP TABLE IF EXISTS Transactions;
CREATE TABLE Transactions (
    trans_id INT,
    account INT,
    amount INT,
    transacted_on DATE,
    PRIMARY KEY (trans_id)
);