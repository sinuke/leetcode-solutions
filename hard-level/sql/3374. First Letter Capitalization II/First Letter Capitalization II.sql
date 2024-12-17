WITH RECURSIVE iter (pos) AS (
    SELECT 1 AS pos
    UNION ALL
    SELECT i.pos + 1
    FROM iter i
    WHERE i.pos + 1 <= (SELECT MAX(LENGTH(content_text)) FROM user_content)
),
t AS (
    SELECT
        content_id,
        content_text,
        iter.pos,
        SUBSTRING(content_text, iter.pos, 1) AS token,
        LAG(SUBSTRING(content_text, iter.pos, 1)) OVER (PARTITION BY content_id ORDER BY iter.pos) AS prev_token
        FROM user_content
        CROSS JOIN iter
        WHERE SUBSTRING(content_text, iter.pos, 1) IS NOT NULL
)
SELECT
    content_id,
    content_text AS original_text,
    GROUP_CONCAT(CASE WHEN prev_token IS NULL OR prev_token IN (' ', '-') THEN UPPER(token) ELSE LOWER(token) END ORDER BY pos SEPARATOR '') AS converted_text
FROM t
GROUP BY content_id, content_text;