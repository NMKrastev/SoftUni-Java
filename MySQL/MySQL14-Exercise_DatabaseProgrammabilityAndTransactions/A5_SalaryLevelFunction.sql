#Write a function ufn_get_salary_level that receives salary of an employee and returns the level of the salary.
#• If salary is < 30000 return "Low"
#• If salary is between 30000 and 50000 (inclusive) return "Average"
#• If salary is > 50000 return "High"
#Submit your query statement as Run skeleton, run queries & check DB in Judge.
DELIMITER $$

CREATE FUNCTION ufn_get_salary_level(`employee_salary` DECIMAL(19, 4))

    RETURNS VARCHAR(10)
    NOT DETERMINISTIC
    READS SQL DATA

BEGIN

    DECLARE `salary_level` VARCHAR(10);

    SET `salary_level` :=
            (SELECT (CASE
                         WHEN `employee_salary` < 30000 THEN 'Low'
                         WHEN `employee_salary` BETWEEN 30000 AND 50000 THEN 'Average'
                         WHEN `employee_salary` > 50000 THEN 'High'
                END));

    RETURN `salary_level`;
END $$

DELIMITER ;

SELECT ufn_get_salary_level(125500);