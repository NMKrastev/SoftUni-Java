#Write a query that selects:
#• country_code
#• mountain_range
#Filter the count of the mountain ranges in the United States, Russia and Bulgaria.
#Sort result by mountain_range count in decreasing order.
SELECT mc.`country_code`,
       COUNT(m.`mountain_range`) AS `mountain_range`
FROM `mountains_countries` AS mc
         JOIN `mountains` AS m ON m.`id` = mc.`mountain_id`
WHERE mc.`country_code` IN ('BG', 'RU', 'US')
GROUP BY mc.`country_code`
ORDER BY `mountain_range` DESC;