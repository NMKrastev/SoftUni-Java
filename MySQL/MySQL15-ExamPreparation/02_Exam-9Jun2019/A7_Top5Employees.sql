SELECT CONCAT_WS(' ', e.`first_name`, e.`last_name`) AS `name`,
       e.`started_on`,
       COUNT(ec.`client_id`) AS `count_of_clients`
FROM `employees` AS e
JOIN employees_clients AS ec ON ec.employee_id = e.id
GROUP BY ec.`employee_id`, e.`id`
ORDER BY `count_of_clients` DESC, e.`id`
LIMIT 5;