#Write a query that returns:
#• first_name
#• last_name
#• department_id
#for all employees who have salary higher than the average salary of their respective departments.
#Select only the first 10 rows. Order by department_id, employee_id.
SELECT e1.`first_name`, e1.`last_name`, e1.`department_id`
FROM `employees` AS e1
WHERE e1.`salary` > (SELECT AVG(e2.`salary`)
                     FROM `employees` AS e2
                     WHERE e1.`department_id` = e2.`department_id`)
ORDER BY e1.`department_id`, e1.`employee_id`
LIMIT 10;