SELECT c.`full_name`,
       COUNT(`car_id`) AS `count_of_cars`,
       SUM(`bill`)     AS `total_sum`
FROM `clients` AS c
         JOIN `courses` AS c2 ON c.`id` = c2.`client_id`
WHERE c.`full_name` LIKE '_a%'
GROUP BY c.`id`, c.`full_name`
HAVING `count_of_cars` > 1
ORDER BY c.`full_name`;