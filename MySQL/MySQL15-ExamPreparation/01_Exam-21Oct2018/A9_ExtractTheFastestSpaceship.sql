SELECT ss.`name` AS `spaceship_name`,
       sp.`name` AS `spaceport_name`
FROM `spaceships` AS ss
         JOIN `journeys` AS j ON j.`spaceship_id` = ss.`id`
         JOIN `spaceports` AS sp ON sp.`id` = j.`destination_spaceport_id`
ORDER BY ss.`light_speed_rate` DESC
LIMIT 1;
