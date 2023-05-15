#Combine all peak names with all river names, so that the last letter of each peak name is the same as the first letter
#of its corresponding river name. Display the peak name, the river name, and the obtained mix(converted to lower case).
#Sort the results by the obtained mix alphabetically. Submit your query statements as Prepare DB & run queries.
SELECT `peak_name`, `river_name`,
       LOWER(CONCAT(`peak_name`, SUBSTRING(`river_name`, 2))) AS mix
FROM peaks, rivers
WHERE RIGHT(`peak_name`, 1) = LEFT(`river_name`, 1)
ORDER BY `mix`;