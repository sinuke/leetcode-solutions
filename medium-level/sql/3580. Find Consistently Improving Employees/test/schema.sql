DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS performance_reviews;

CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE performance_reviews (
    review_id INT PRIMARY KEY,
    employee_id INT,
    review_date DATE,
    rating INT
);
