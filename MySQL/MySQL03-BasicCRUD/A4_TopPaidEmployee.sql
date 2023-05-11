#Write a query to create a view that selects all information about
#the top paid employee from the "employees" table in the hotel database.
CREATE VIEW `v_top_paid_employee` AS
    SELECT *
    FROM `employees`
    ORDER BY `salary` DESC
    LIMIT 1;

SELECT * FROM `v_top_paid_employee`;