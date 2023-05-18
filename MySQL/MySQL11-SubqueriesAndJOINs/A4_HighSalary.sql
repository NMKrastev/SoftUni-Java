#Write a query to count the number of employees who receive salary higher than the average.
#Submit your queries using the "MySQL prepare DB and Run Queries" strategy.
SELECT COUNT(*)
FROM `employees` AS e1
WHERE e1.`salary` > (SELECT AVG(e2.`salary`)
                    FROM `employees` AS e2);