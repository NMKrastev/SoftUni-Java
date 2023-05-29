DELIMITER $$

CREATE FUNCTION udf_users_photos_count(username VARCHAR(30))

    RETURNS INT
    DETERMINISTIC
    READS SQL DATA

BEGIN

    DECLARE `count` INT;

    SET `count` := (SELECT COUNT(up.`photo_id`)
                    FROM `users_photos` AS up
                             JOIN `users` AS u ON up.`user_id` = u.`id`
                    WHERE u.`username` = `username`);

    RETURN `count`;

END $$