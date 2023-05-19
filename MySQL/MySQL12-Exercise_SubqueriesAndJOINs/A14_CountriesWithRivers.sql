#Write a query that selects:
#• country_name
#• river_name
#Find the first 5 countries with or without rivers in Africa.
#Sort them by country_name in ascending order.
SELECT c.`country_name`,
       r.`river_name`
FROM `countries` AS c
         LEFT JOIN `countries_rivers` AS cr ON cr.`country_code` = c.`country_code`
         LEFT JOIN `rivers` AS r ON r.`id` = cr.`river_id`
WHERE c.`continent_code` = 'AF'
ORDER BY c.`country_name`
LIMIT 5;
