#Find the top 50 games ordered by start date, then by name. Display only the games from the years 2011 and 2012.
#Display the start date in the format "YYYY-MM-DD". Submit your query statements as Prepare DB & run queries.
SELECT `name`, DATE_FORMAT(`start`, '%Y-%m-%d') AS `start`
FROM `games`
WHERE YEAR(`start`) IN (2011, 2012)
ORDER BY `start`, `name`
LIMIT 50;