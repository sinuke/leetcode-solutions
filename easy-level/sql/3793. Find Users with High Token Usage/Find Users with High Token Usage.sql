SELECT user_id, COUNT(tokens) AS prompt_count, ROUND(AVG(tokens), 2) AS avg_tokens
FROM prompts p1
GROUP BY user_id
HAVING prompt_count > 2 AND EXISTS (
    SELECT 1
    FROM prompts p2
    WHERE p2.user_id = p1.user_id AND p2.tokens > ROUND(AVG(p1.tokens), 2)
)
ORDER BY avg_tokens DESC, user_id ASC;