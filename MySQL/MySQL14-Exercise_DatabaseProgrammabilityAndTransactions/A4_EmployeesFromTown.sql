#Write a stored procedure usp_get_employees_from_town that accepts town_name as parameter
#and return the employees' first and last name that live in the given town.
#The result should be sorted by first_name then by last_name alphabetically and id ascending.
#Submit your query statement as Run skeleton, run queries & check DB in Judge.
DELIMITER $$

CREATE PROCEDURE usp_get_employees_from_town(`town_name` VARCHAR(30))
BEGIN
    SELECT `first_name`,
           `last_name`
    FROM `employees` AS e
             JOIN addresses AS a ON a.address_id = e.address_id
             JOIN towns AS t ON t.town_id = a.town_id
    WHERE t.`name` = `town_name`
    ORDER BY e.`first_name`, e.`last_name`, e.`employee_id`;
END $$

DELIMITER ;

CALL usp_get_employees_from_town('Sofia');