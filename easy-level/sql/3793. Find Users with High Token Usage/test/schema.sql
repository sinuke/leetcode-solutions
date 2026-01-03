DROP TABLE IF EXISTS prompts;
CREATE TABLE prompts (
    user_id INT,
    prompt VARCHAR(255),
    tokens INT
);