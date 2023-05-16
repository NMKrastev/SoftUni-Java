#Write a query to calculate the average salary in each department. Order the information by department_id.
#Round the salary result to two digits after the decimal point.
#Submit your queries with the MySQL prepare DB & run queries strategy.
SELECT `department_id`, ROUND(AVG(`salary`), 2) AS `Average Salary`
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;