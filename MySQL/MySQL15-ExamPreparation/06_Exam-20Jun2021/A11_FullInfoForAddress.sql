DELIMITER $$

CREATE PROCEDURE udp_courses_by_address(`address_name` VARCHAR(100))

BEGIN

    SELECT a.`name`,
           c.`full_name` AS `full_names`,
           (CASE
                WHEN cr.`bill` <= 20 THEN 'Low'
                WHEN cr.`bill` <= 30 THEN 'Medium'
                ELSE 'High'
               END)      AS `level_of_bill`,
           ca.`make`,
           ca.`condition`,
           cat.`name`    AS `cat_name`
    FROM `addresses` AS a
             JOIN `courses` AS cr ON a.`id` = cr.`from_address_id`
             JOIN `clients` AS c ON c.`id` = cr.`client_id`
             JOIN cars AS ca ON ca.`id` = cr.`car_id`
             JOIN `categories` AS cat ON cat.`id` = ca.`category_id`
    WHERE a.`name` = `address_name`
    ORDER BY ca.`make`, c.`full_name`;

END $$
