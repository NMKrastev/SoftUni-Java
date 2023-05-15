#Write a SQL query to create view v_employees_hired_after_2000 with the first and the last name of all employees
#hired after 2000 year. Select all from the created view.
#Submit your queries as Run skeleton, run queries & check DB.
CREATE VIEW `v_employees_hired_after_2000` AS
    SELECT `first_name`, `last_name`
    FROM `employees`
    WHERE YEAR(`hire_date`) > 2000;

SELECT * FROM `v_employees_hired_after_2000`;