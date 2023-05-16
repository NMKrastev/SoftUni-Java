#Write a query to count the number of employees in each department by id.
#Order the information by department_id, then by Number of employees.
#Submit your queries with the MySQL prepare DB & run queries strategy.
SELECT `department_id`, COUNT(`id`) AS `Number of employees`
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`, `Number of employees`;