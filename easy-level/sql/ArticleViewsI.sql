SELECT author_id AS id
FROM (
    SELECT *
    FROM Views
    WHERE author_id = viewer_id
) t
GROUP BY author_id
ORDER by id;