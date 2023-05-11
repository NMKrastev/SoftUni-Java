#Write a SQL query to find the first and last names of all employees whose department ID is different from 4.
#Submit your query statements as Prepare DB & run queries.
SELECT `first_name`, `last_name`
FROM `employees`
WHERE NOT `department_id` = 4;