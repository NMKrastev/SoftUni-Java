DELIMITER $$

CREATE PROCEDURE udp_modify_user(`address` VARCHAR(30), `town` VARCHAR(30))

BEGIN

    DECLARE `user_id` INT;

    SELECT u.`id`
    INTO `user_id`
    FROM `users` AS u
             JOIN `addresses` AS a ON u.`id` = a.`user_id`
    WHERE a.`address` = `address`
      AND a.`town` = `town`;

    IF `user_id` IS NOT NULL
    THEN
        UPDATE `users`
        SET `age` = `age` + 10
        WHERE `id` = `user_id`;
    END IF;

END $$
