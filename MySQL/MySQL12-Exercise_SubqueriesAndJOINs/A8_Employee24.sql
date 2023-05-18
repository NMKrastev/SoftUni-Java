#Write a query that selects:
#• employee_id
#• first_name
#• project_name
#Filter all the projects of employees with id 24.
#If the project has started after 2005 inclusively the return value should be NULL.
#Sort the result by project_name alphabetically.
SELECT e.`employee_id`,
       e.`first_name`,
       IF(YEAR(p.`start_date`) >= 2005, NULL, p.`name`)
           AS `project_name`
FROM `employees` AS e
         JOIN `employees_projects` AS ep
              ON ep.`employee_id` = e.`employee_id`
         JOIN `projects` AS p
              ON p.`project_id` = ep.`project_id`
WHERE e.`employee_id` = 24
ORDER BY `project_name`;