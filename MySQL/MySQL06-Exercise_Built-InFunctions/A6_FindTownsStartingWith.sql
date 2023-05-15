#Write a SQL query to find all towns that start with letters M, K, B or E (case insensitively).
#Order them alphabetically by town name. Submit your query statements as Prepare DB & run queries.
SELECT `town_id`, `name`
FROM `towns`
WHERE SUBSTRING(`name`, 1, 1) IN ('M', 'K', 'B', 'E')
ORDER BY `name`;