DELIMITER $$

CREATE FUNCTION udf_count_colonists_by_destination_planet(planet_name VARCHAR(30))
    RETURNS INT
    NOT DETERMINISTIC
    READS SQL DATA

BEGIN

    DECLARE `count` INT;

    SET `count` := (SELECT COUNT(*)
                    FROM `colonists` AS c
                             JOIN `travel_cards` AS tc ON tc.`colonist_id` = c.`id`
                             JOIN `journeys` AS j ON j.`id` = tc.`journey_id`
                             JOIN `spaceports` AS s ON s.`id` = j.`destination_spaceport_id`
                             JOIN `planets` AS p ON p.`id` = s.`planet_id`
                    WHERE p.`name` = `planet_name`);

    RETURN count;

END $$
