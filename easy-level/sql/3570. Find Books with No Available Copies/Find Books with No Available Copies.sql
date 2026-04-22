# Write your MySQL query statement below
WITH tmp1 AS (
    SELECT book_id, COUNT(record_id) AS cnt
    FROM borrowing_records
    WHERE return_date IS NULL
    GROUP BY book_id
)
SELECT l.book_id, l.title, l.author, l.genre, l.publication_year, t.cnt as current_borrowers
FROM library_books AS l
         JOIN tmp1 AS t
              ON l.book_id = t.book_id AND l.total_copies = t.cnt
ORDER BY current_borrowers DESC, title ASC;