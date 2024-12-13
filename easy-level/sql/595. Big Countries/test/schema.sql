DROP TABLE IF EXISTS World;
CREATE TABLE World (
    name VARCHAR(255),
    continent VARCHAR(255),
    area INT,
    population INT,
    gdp BIGINT,
    PRIMARY KEY (name)
);