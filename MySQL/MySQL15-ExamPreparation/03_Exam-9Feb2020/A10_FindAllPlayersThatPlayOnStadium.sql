DELIMITER $$

CREATE FUNCTION udf_stadium_players_count(stadium_name VARCHAR(30))

    RETURNS INT
    NOT DETERMINISTIC
    READS SQL DATA

BEGIN

    DECLARE count INT;

    SET count := (SELECT COUNT(p.`id`)
                  FROM `players` AS p
                           JOIN `teams` AS t ON t.`id` = p.`team_id`
                           JOIN `stadiums` AS s ON s.`id` = t.`stadium_id`
                  WHERE s.`name` = `stadium_name`);


    RETURN count;

END $$
