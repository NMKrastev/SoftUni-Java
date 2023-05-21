#Write a stored procedure usp_raise_salaries(department_name) to raise the salary of all employees
#in given department as parameter by 5%.
#Submit your queries using the "MySQL Run Skeleton, run queries and check DB" strategy.
DELIMITER $$

CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(50))
BEGIN
    UPDATE `employees` AS e
        JOIN departments d on d.department_id = e.department_id
    SET `salary` = `salary` * 1.05
    WHERE d.`name` = department_name;
END $$

DELIMITER ;

CALL usp_raise_salaries('Executive');

DROP PROCEDURE usp_raise_salaries;