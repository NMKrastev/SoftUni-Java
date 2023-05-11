#Write a SQL query to find last 7 hired employees. Select their first, last name and their hire date.
#Submit your query statements as Prepare DB & run queries.
SELECT `first_name`, `last_name`, `hire_date`
FROM `employees`
ORDER BY `hire_date` DESC
LIMIT 7;