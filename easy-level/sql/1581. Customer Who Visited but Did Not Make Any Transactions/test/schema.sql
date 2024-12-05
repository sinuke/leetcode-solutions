DROP TABLE IF EXISTS Visits;
CREATE TABLE Visits (
    visit_id INT PRIMARY KEY,
    customer_id INT
);

DROP TABLE IF EXISTS Transactions;
CREATE TABLE Transactions (
    transaction_id INT PRIMARY KEY,
    visit_id INT,
    amount INT
);