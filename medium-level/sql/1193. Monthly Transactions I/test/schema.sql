DROP TABLE IF EXISTS Transactions;
CREATE TABLE Transactions (
    id INT,
    country VARCHAR(4),
    state ENUM('approved', 'declined'),
    amount INT,
    trans_date DATE,
    PRIMARY KEY (id)
);