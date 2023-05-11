#Write SQL query to find the first, middle and last name of each employee.
#Sort the information by id. Submit your query statements as Prepare DB & run queries.
SELECT `first_name`, `middle_name`, `last_name`
FROM employees
ORDER BY `employee_id`;