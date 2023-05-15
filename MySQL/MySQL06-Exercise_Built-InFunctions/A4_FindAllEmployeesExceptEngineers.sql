#Write a SQL query to find the first and last names of all employees whose job titles does not contain "engineer".
#Order the information by id. Submit your query statements as Prepare DB & run queries.
SELECT `first_name`, `last_name`
FROM `employees`
WHERE NOT `job_title` LIKE '%engineer%'
ORDER BY `employee_id`;