SELECT a.`name`,
       (CASE
            WHEN HOUR(cr.`start`) BETWEEN 6 AND 20 THEN 'Day'
            ELSE 'Night'
           END)   AS `day_time`,
       cr.`bill`,
       cl.`full_name`,
       ca.`make`,
       ca.`model`,
       cat.`name` AS `category_name`
FROM `addresses` AS a
         JOIN `courses` AS cr ON a.`id` = cr.`from_address_id`
         JOIN `clients` AS cl ON cl.`id` = cr.`client_id`
         JOIN `cars` AS ca ON ca.`id` = cr.`car_id`
         JOIN `categories` AS cat ON cat.`id` = ca.`category_id`
ORDER BY cr.`id`;
