#Write a function ufn_count_employees_by_town(town_name) that accepts town_name as parameter
#and returns the count of employees who live in that town.
#Submit your queries using the "MySQL Run Skeleton, run queries and check DB" strategy.
DELIMITER $$

CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(50))
    RETURNS INT
    NOT DETERMINISTIC
    CONTAINS SQL
    READS SQL DATA
BEGIN
    DECLARE count_by_town INT;
    SET count_by_town := (SELECT COUNT(*)
                          FROM `employees` AS e
                                   JOIN `addresses` AS a ON a.`address_id` = e.`address_id`
                                   JOIN `towns` AS t ON t.`town_id` = a.`town_id`
                          WHERE t.`name` = town_name);
    RETURN count_by_town;
END $$

DELIMITER ;

SELECT ufn_count_employees_by_town('Sofia') AS `count`;

DROP FUNCTION ufn_count_employees_by_town;