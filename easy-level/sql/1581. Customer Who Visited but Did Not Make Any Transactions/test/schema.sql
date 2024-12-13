DROP TABLE IF EXISTS Visits;
CREATE TABLE Visits (
    visit_id INT,
    customer_id INT,
    PRIMARY KEY (visit_id)
);

DROP TABLE IF EXISTS Transactions;
CREATE TABLE Transactions (
    transaction_id INT,
    visit_id INT,
    amount INT,
    PRIMARY KEY (transaction_id)
);