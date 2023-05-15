#Write a SQL query to find the first names of all employees in the departments with ID 3 or 10
#and whose hire year is between 1995 and 2005 inclusively. Order the information by id.
#Submit your query statements as Prepare DB & run queries.
SELECT `first_name`
FROM `employees`
WHERE `department_id` IN (3, 10)
AND YEAR(`hire_date`) BETWEEN 1995 AND 2005
ORDER BY `employee_id`;