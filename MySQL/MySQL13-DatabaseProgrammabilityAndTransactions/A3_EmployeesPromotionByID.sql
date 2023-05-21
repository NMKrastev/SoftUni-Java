#Write a stored procedure usp_raise_salary_by_id(id) that raises a given employee's salary (by id as parameter) by 5%.
#Consider that you cannot promote an employee that doesn't exist
#– if that happens, no changes to the database should be made.
#Submit your queries using the "MySQL Run Skeleton, run queries and check DB" strategy.
DELIMITER $$

CREATE PROCEDURE usp_raise_salary_by_id(id INT)
BEGIN

    DECLARE count_by_id INT;

    START TRANSACTION;
    SET count_by_id := (SELECT COUNT(*)
                        FROM `employees`
                        WHERE `employee_id` = id);

    UPDATE `employees`
    SET `salary` = `salary` * 1.05
    WHERE `employee_id` = id;

    IF (count_by_id < 1) THEN
        ROLLBACK;
    ELSE
        COMMIT;

    END IF;
END $$

DELIMITER ;

CALL usp_raise_salary_by_id(17);

SELECT * FROM `employees`
WHERE `employee_id` = 17;

DROP PROCEDURE usp_raise_salary_by_id;