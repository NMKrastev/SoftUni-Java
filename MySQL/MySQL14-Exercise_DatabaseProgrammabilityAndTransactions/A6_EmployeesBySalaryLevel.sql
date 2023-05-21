#Write a stored procedure usp_get_employees_by_salary_level that receive as parameter level of salary (low, average or high)
#and print the names of all employees that have given level of salary.
#The result should be sorted by first_name then by last_name both in descending order.
#Submit your query statement as Run skeleton, run queries & check DB in Judge.
DELIMITER $$

CREATE PROCEDURE usp_get_employees_by_salary_level(`level_of_salary` VARCHAR(10))
BEGIN
    SELECT `first_name`,
           `last_name`
    FROM `employees`
    WHERE (CASE
               WHEN `level_of_salary` = 'low' THEN `salary` < 30000
               WHEN `level_of_salary` = 'average' THEN `salary` BETWEEN 30000 AND 50000
               WHEN `level_of_salary` = 'high' THEN `salary` > 50000
        END)
    ORDER BY `first_name` DESC, last_name DESC;
END $$

DELIMITER ;

CALL usp_get_employees_by_salary_level('high');