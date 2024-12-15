DROP TABLE IF EXISTS Movies;
CREATE TABLE Movies (
    movie_id INT,
    title VARCHAR(255),
    PRIMARY KEY (movie_id)
);

DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
    user_id INT,
    name VARCHAR(255),
    PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS MovieRating;
CREATE TABLE MovieRating (
    movie_id INT,
    user_id INT,
    rating INT,
    created_at DATE,
    PRIMARY KEY (movie_id, user_id)
);