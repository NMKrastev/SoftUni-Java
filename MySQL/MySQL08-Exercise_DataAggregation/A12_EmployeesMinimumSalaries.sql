#Select the minimum salary from the employees for departments with ID (2,5,7) but only for those who are hired after 01/01/2000.
# Sort result by department_id in ascending order.
#Your query should return:
#• department_id
SELECT `department_id`, MIN(`salary`) AS `minimum_salary`
FROM `employees`
WHERE `department_id` IN (2, 5, 7)
GROUP BY `department_id`
ORDER BY `department_id`;