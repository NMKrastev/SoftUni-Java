#Write a SQL query to find all towns that do not start with letters R, B or D (case insensitively).
#Order them alphabetically by name. Submit your query statements as Prepare DB & run queries.
SELECT `town_id`, `name`
FROM `towns`
WHERE NOT SUBSTRING(`name`, 1, 1) IN ('R', 'B', 'D')
ORDER BY `name`;