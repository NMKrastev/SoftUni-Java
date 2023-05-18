#Write a query to retrieve information about the managers – id, full_name, deparment_id and department_name.
#Select the first 5 departments ordered by employee_id.
#Submit your queries using the "MySQL prepare DB and Run Queries" strategy.
SELECT e.`employee_id`,
       CONCAT_WS(' ', `first_name`, `last_name`) AS `full_name`,
       d.`department_id`,
       d.`name` AS `department_name`
FROM `employees` AS e
JOIN  `departments` AS d ON e.`employee_id` = d.`manager_id`
ORDER BY e.`employee_id`
LIMIT 5;