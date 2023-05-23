DELIMITER $$

CREATE PROCEDURE udp_clientinfo(full_name VARCHAR(50))

BEGIN
    SELECT c.`full_name`,
           c.`age`,
           ba.`account_number`,
           CONCAT('$', ba.`balance`)
    FROM `clients` AS c
    JOIN `bank_accounts` AS ba ON ba.`client_id` = c.`id`
    WHERE c.`full_name` = `full_name`;
END $$