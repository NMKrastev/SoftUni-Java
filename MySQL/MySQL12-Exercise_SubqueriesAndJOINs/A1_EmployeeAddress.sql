#Write a query that selects:
#• employee_id
#• job_title
#• address_id
#• address_text
#Return the first 5 rows sorted by address_id in ascending order.
SELECT e.`employee_id`, e.`job_title`, e.`address_id`, a.`address_text`
FROM `employees` AS e
JOIN `addresses` a on a.address_id = e.address_id
ORDER BY `address_id`
LIMIT 5;