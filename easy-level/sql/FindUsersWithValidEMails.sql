-- Submitted solution to LeetCode:
-- SELECT user_id, name, mail
-- FROM Users
-- WHERE mail REGEXP '^[a-zA-Z][a-zA-Z0-9_\.-]*@leetcode\\.com';

-- Solution for unit tests (H2 Database limitations):
SELECT user_id, name, mail
FROM Users
WHERE mail REGEXP '^[a-zA-Z][a-zA-Z0-9_\.-]*@leetcode\.com';