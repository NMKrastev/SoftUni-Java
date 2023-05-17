#Count the salaries of all employees who don't have a manager.
SELECT COUNT(`salary`) as `count`
FROM `employees`
WHERE `manager_id` IS NULL;