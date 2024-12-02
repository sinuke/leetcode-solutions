-- Submitted solution for LeetCode:
-- SELECT patient_id, patient_name, conditions
-- FROM Patients
-- WHERE conditions REGEXP '(?<=^|\\s)DIAB1';

-- Solution for unit tests (H2 Database limitations):
SELECT patient_id, patient_name, conditions
FROM Patients
WHERE conditions REGEXP '(?<=^|\s)DIAB1';