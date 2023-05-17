#Display all peaks for "Rila" mountain_range. Include:
#• mountain_range
#• peak_name
#• peak_elevation
#Peaks should be sorted by peak_elevation descending.

SELECT `mountain_range`, `peak_name`, `elevation`
FROM `mountains` AS m
         JOIN `peaks` AS p ON m.`id` = p.`mountain_id`
WHERE m.`id` = 17
ORDER BY p.`elevation` DESC;