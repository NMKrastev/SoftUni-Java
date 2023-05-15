#Write a SQL query to find town names that are 5 or 6 symbols long and order them alphabetically by town name.
#Submit your query statements as Prepare DB & run queries.
SELECT `name`
FROM `towns`
WHERE LENGTH(`name`) IN (5, 6)
ORDER BY `name`;