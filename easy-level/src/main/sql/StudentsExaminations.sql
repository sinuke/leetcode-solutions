WITH students_and_exams_full AS (
    SELECT Students.student_id, Students.student_name, Subjects.subject_name
    FROM Students
    JOIN Subjects
    ON Subjects.subject_name IS NOT NULL
),
students_with_scheduled_exams AS (
    SELECT Students.student_id, student_name, subject_name
    FROM Students
    JOIN Examinations
    ON Students.student_id = Examinations.student_id
),
counted AS (
    SELECT student_id, student_name, subject_name, COUNT(student_id) AS attended_exams
    FROM students_with_scheduled_exams
    GROUP BY student_id, student_name, subject_name
),
no_exams AS (
    SELECT s.student_id, s.student_name, s.subject_name, 0 AS attended_exams
    FROM students_and_exams_full s
    WHERE s.subject_name NOT IN (SELECT subject_name FROM counted c WHERE s.student_id = c.student_id)
)
SELECT * FROM counted
UNION
SELECT * FROM no_exams
ORDER BY student_id, subject_name;