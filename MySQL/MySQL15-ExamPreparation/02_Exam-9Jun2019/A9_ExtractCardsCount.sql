DELIMITER $$

CREATE FUNCTION udf_client_cards_count(name VARCHAR(30))
RETURNS INT
NOT DETERMINISTIC
READS SQL DATA

BEGIN
    DECLARE result INT;

    SET result := (SELECT COUNT(c.`id`) AS `count`
                   FROM `clients` AS cl
                   JOIN `bank_accounts` AS ba ON ba.`client_id` = cl.`id`
                   JOIN `cards` AS c ON c.`bank_account_id` = ba.`id`
                   WHERE cl.`full_name` = `name`);

    RETURN result;

END $$

DELIMITER ;

SELECT COUNT(c.`id`) AS `count`
FROM `clients` AS cl
         JOIN `bank_accounts` AS ba ON ba.`client_id` = cl.`id`
         JOIN `cards` AS c ON c.`bank_account_id` = ba.`id`
WHERE cl.`full_name` = `name`