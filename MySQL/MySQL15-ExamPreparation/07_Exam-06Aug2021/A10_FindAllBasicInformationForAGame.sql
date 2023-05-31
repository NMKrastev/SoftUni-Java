DELIMITER $$

CREATE FUNCTION udf_game_info_by_name(game_name VARCHAR(20))
    RETURNS TEXT
    DETERMINISTIC
    READS SQL DATA

BEGIN

    DECLARE `result` TEXT;

    SET `result` := (SELECT CONCAT_WS(' ', 'The', g.`name`, 'is developed by a', t.`name`, 'in an office with an address', a.`name`)
                     FROM `games` AS g
                              JOIN `teams` AS t ON t.`id` = g.`team_id`
                              JOIN `offices` AS o ON o.`id` = t.`office_id`
                              JOIN `addresses` AS a ON a.`id` = o.`address_id`
                     WHERE g.`name` = `game_name`);

    RETURN `result`;

END $$
