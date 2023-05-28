UPDATE `employees` AS e
SET e.`manager_id` = 3, e.`salary` = e.`salary` - 500
WHERE YEAR(e.`hire_date`) >= 2003
  AND e.`store_id` NOT IN (SELECT s.`id`
                         FROM `stores` AS s
                         WHERE s.`name` IN ('Cardguard', 'Veribet'));
