CREATE TABLE UserActivity
(
    user_id           INT,
    activity_date     DATE,
    activity_type     VARCHAR(20),
    activity_duration INT,
    PRIMARY KEY (user_id, activity_date, activity_type)
);
