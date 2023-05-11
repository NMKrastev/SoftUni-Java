#Write a SQL query to find the email address of each employee. (by his first and last name).
#Consider that the email domain is softuni.bg. Emails should look like "John.Doe@softuni.bg".
#The produced column should be named "full_ email_address". Submit your query statements as Prepare DB & run queries.
SELECT CONCAT(`first_name`, '.', `last_name`, '@softuni.bg') AS `full_email_adress`
FROM employees;