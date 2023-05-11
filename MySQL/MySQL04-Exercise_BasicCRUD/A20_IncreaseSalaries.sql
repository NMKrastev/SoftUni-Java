#Write a SQL query to increase salaries of all employees that are in the Engineering, Tool Design,
#Marketing or Information Services department by 12%. Then select Salaries column from the Employees table.
#Submit your query statements as Prepare DB & run queries.
UPDATE `employees`
SET `salary` = `salary` * 1.12
WHERE `department_id` = 1 OR `department_id` = 2 OR `department_id` = 4 OR `department_id` = 11;

SELECT `salary`
FROM `employees`;
