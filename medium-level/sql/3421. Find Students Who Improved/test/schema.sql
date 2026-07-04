DROP TABLE IF EXISTS Scores;
CREATE TABLE Scores (
    student_id INT,
    subject VARCHAR(50),
    score INT,
    exam_date VARCHAR(10),
    PRIMARY KEY (student_id, subject, exam_date)
);
