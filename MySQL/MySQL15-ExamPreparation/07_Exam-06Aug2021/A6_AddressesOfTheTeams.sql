SELECT t.`name`              AS `team_name`,
       a.`name`              AS `address_name`,
       CHAR_LENGTH(a.`name`) AS `count_of_characters`
FROM `teams` AS t
         JOIN `offices` AS o ON t.`office_id` = o.`id`
         JOIN `addresses` AS a ON a.`id` = o.`address_id`
WHERE o.`website` IS NOT NULL
ORDER BY t.`name`, a.`name`;
