DELIMITER $$

CREATE PROCEDURE udp_find_playmaker(`min_dribble_points` INT, `team_name` VARCHAR(45))

BEGIN

    SELECT CONCAT_WS(' ', p.`first_name`, p.`last_name`) AS `full_name`,
           p.`age`,
           p.`salary`,
           sd.`dribbling`,
           sd.`speed`,
           t.`name`
    FROM `players` AS p
             JOIN `skills_data` AS sd ON sd.`id` = p.`skills_data_id`
             JOIN `teams` AS t ON t.`id` = p.`team_id`
    WHERE sd.`dribbling` > `min_dribble_points`
      AND t.`name` = `team_name`
      AND sd.speed > (SELECT AVG(`speed`)
                      FROM `skills_data`)
    ORDER BY sd.`speed` DESC
    LIMIT 1;

END $$