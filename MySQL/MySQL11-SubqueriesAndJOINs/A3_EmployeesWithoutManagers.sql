#Write a query to get information about employee_id, first_name, last_name, department_id and salary
#for all employees who don't have a manager.
#Submit your queries using the "MySQL prepare DB and Run Queries" strategy.
SELECT `employee_id`, `first_name`, `last_name`, `department_id`, `salary`
FROM `employees`
WHERE `manager_id` IS NULL;