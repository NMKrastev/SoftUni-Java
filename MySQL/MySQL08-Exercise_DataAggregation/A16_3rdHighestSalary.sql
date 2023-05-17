#Find the third highest salary in each department if there is such. Sort result by department_id in increasing order.
SELECT e1.`department_id`,
       (SELECT DISTINCT e2.`salary`
        FROM `employees` AS e2
        WHERE e1.`department_id` = e2.`department_id`
        ORDER BY e2.`salary` DESC
        LIMIT 1 OFFSET 2) AS `third_highest_salary`
FROM `employees` AS e1
GROUP BY department_id
HAVING `third_highest_salary` IS NOT NULL
ORDER BY `department_id`;