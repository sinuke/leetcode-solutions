DROP TABLE IF EXISTS RequestAccepted;
CREATE TABLE RequestAccepted (
    requester_id INT,
    accepter_id INT,
    accept_date DATE
);