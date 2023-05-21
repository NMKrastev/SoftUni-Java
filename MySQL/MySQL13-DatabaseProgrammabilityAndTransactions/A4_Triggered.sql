#Create a table deleted_employees(employee_id PK, first_name,last_name,middle_name,job_title,department_id,salary)
#that will hold information about fired(deleted) employees from the employees table.
#Add a trigger to employees table that inserts the corresponding information in deleted_employees.
#Submit your queries using the "MySQL Run Skeleton, run queries and check DB" strategy.
CREATE TABLE `deleted_employees`
(
    `employee_id` INT PRIMARY KEY AUTO_INCREMENT,
    first_name    VARCHAR(50),
    last_name     VARCHAR(50),
    middle_name   VARCHAR(50),
    job_title     VARCHAR(50),
    department_id INT,
    salary        DOUBLE
);

DELIMITER $$

CREATE TRIGGER `tr_deleted_employees`
    AFTER DELETE
    ON `employees`
    FOR EACH ROW
BEGIN

    INSERT INTO `deleted_employees` (`first_name`,
                                     `last_name`,
                                     `middle_name`,
                                     `job_title`,
                                     `department_id`,
                                     `salary`)
    VALUES (OLD.`first_name`,
            OLD.`last_name`,
            OLD.`middle_name`,
            OLD.`job_title`,
            OLD.`department_id`,
            OLD.`salary`);
END $$

DELIMITER ;

SELECT *
FROM `deleted_employees`;

DELETE
FROM `employees`
WHERE `employee_id` = 2;

