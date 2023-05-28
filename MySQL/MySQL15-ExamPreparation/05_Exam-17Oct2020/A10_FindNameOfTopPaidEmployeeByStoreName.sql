DELIMITER $$

CREATE FUNCTION udf_top_paid_employee_by_store(store_name VARCHAR(50))

    RETURNS VARCHAR(250)
    DETERMINISTIC
    READS SQL DATA

BEGIN

    DECLARE `result` VARCHAR(250);

    SET result := (SELECT CONCAT_WS(' ', e.`first_name`, CONCAT(e.`middle_name`, '.'), e.`last_name`, 'works in store for',
                                    2020 - YEAR(e.`hire_date`), 'years')
                   FROM `employees` AS e
                            JOIN `stores` AS s ON s.`id` = e.`store_id`
                   WHERE s.`name` = `store_name`
                   ORDER BY e.`salary` DESC
                   LIMIT 1);

    RETURN `result`;

END $$

DELIMITER ;

SELECT CONCAT_WS(' ', e.`first_name`, CONCAT(e.`middle_name`, '.'), e.`last_name`, 'works in store for',
                 2020 - YEAR(e.`hire_date`), 'years')
FROM `employees` AS e
         JOIN `stores` AS s ON s.`id` = e.`store_id`
WHERE s.`name` = 'Stronghold'
ORDER BY e.`salary` DESC
LIMIT 1;