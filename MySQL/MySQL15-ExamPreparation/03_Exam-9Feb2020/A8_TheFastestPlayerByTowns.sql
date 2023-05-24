SELECT MAX(sd.`speed`) AS `max_speed`,
       towns.`name`    AS `town_name`
FROM `skills_data` AS sd
         RIGHT JOIN `players` AS p ON p.`skills_data_id` = sd.`id`
         RIGHT JOIN `teams` AS t ON t.`id` = p.`team_id`
         RIGHT JOIN `stadiums` AS s ON s.`id` = t.`stadium_id`
         RIGHT JOIN towns ON towns.`id` = s.`town_id`
WHERE t.`name` != 'Devify'
GROUP BY `town_name`
ORDER BY `max_speed` DESC, `town_name`;