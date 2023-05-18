#Write a query that selects:
#• first_name
#• last_name
#• town
#• address_text
#Sort the result by first_name in ascending order then by last_name. Select first 5 employees.
SELECT e.`first_name`, e.`last_name`, t.`name`, a.`address_text`
FROM `employees` AS e
JOIN `addresses` AS a ON e.`address_id` = a.`address_id`
JOIN `towns` AS t ON a.`town_id` = t.`town_id`
ORDER BY e.`first_name`, e.`last_name`
LIMIT 5;