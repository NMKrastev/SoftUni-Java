#Write a stored procedure usp_get_towns_starting_with that accept string as parameter
#and returns all town names starting with that string.
#The result should be sorted by town_name alphabetically.
#Submit your query statement as Run skeleton, run queries & check DB in Judge.
DELIMITER $$

CREATE PROCEDURE usp_get_towns_starting_with(`starts_with` VARCHAR(10))
BEGIN
    SELECT `name` AS `town_name`
    FROM `towns`
    WHERE `name` LIKE CONCAT(starts_with, '%')
    ORDER BY `town_name`;
END $$

DELIMITER ;

CALL usp_get_towns_starting_with('b');