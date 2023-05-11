#Write a SQL query to find first 10 started projects.
#Select all information about them and sort them by start date, then by name.
#Sort the information by id. Submit your query statements as Prepare DB & run queries.
SELECT * FROM `projects`
WHERE `start_date` IS NOT NULL
ORDER BY `start_date`, `name`
LIMIT 10;
