#Write a query that selects:
#• employee_id
#• first_name
#Filter only employees without a project. Return the first 3 rows sorted by employee_id in descending order.
SELECT e.`employee_id`, e.`first_name`
FROM `employees` AS e
WHERE e.`employee_id` NOT IN (SELECT ep.`employee_id`
                          FROM employees_projects AS ep)
ORDER BY e.`employee_id` DESC
LIMIT 3;