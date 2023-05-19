#Find the count of all countries which don't have a mountain.
SELECT COUNT(c.`country_code`) AS `country_count`
FROM `countries` AS c
WHERE c.`country_code` NOT IN (SELECT mc.`country_code`
                               FROM `mountains_countries` AS mc);