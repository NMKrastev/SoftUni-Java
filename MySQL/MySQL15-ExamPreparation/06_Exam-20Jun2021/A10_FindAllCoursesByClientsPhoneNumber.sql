DELIMITER $$

CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR (20))

RETURNS INT
DETERMINISTIC
READS SQL DATA

BEGIN

    DECLARE `count` INT;

    SET `count` := (SELECT COUNT(cr.`client_id`)
                    FROM `courses` AS cr
                    JOIN `clients` AS c ON c.`id` = cr.`client_id`
                    WHERE c.`phone_number` = `phone_num`);

    RETURN `count`;

END $$
