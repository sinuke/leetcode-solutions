DROP TABLE IF EXISTS logs;
CREATE TABLE logs (
    log_id INT,
    ip VARCHAR(20),
    status_code INT,
    PRIMARY KEY (log_id)
);
