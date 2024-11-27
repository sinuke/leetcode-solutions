SELECT id FROM (
    SELECT
        id,
        temperature - LAG(temperature) OVER (ORDER BY recordDate) AS temp_dif,
        DATEDIFF(recordDate, LAG(recordDate) OVER (ORDER BY recordDate)) AS date_dif
    FROM Weather
) diffs
WHERE temp_dif > 0 AND date_dif = 1;