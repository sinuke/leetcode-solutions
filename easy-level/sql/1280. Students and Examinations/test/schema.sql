DROP TABLE IF EXISTS Students;
CREATE TABLE Students (
    student_id INT,
    student_name VARCHAR(255)
);

DROP TABLE IF EXISTS Subjects;
CREATE TABLE Subjects (
    subject_name VARCHAR(255)
);

DROP TABLE IF EXISTS Examinations;
CREATE TABLE Examinations (
    student_id INT,
    subject_name VARCHAR(255)
);