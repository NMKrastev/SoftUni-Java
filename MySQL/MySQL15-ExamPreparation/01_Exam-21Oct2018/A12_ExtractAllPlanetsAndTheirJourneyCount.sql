SELECT p.`name` AS `planet_name`,
       COUNT(p.`name`) AS `journey_count`
FROM `planets` AS p
         JOIN `spaceports` AS sp ON sp.`planet_id` = p.`id`
         JOIN `journeys` AS j ON j.`destination_spaceport_id` = sp.`id`
GROUP BY `planet_name`
ORDER BY `journey_count` DESC, `planet_name`;