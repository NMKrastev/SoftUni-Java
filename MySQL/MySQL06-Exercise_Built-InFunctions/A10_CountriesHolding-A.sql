#Find all countries that hold the letter 'A' in their name at least 3 times (case insensitively), sorted by ISO code.
#Display the country name and the ISO code. Submit your query statements as Prepare DB & run queries.
SELECT `country_name`, `iso_code`
FROM `countries`
WHERE `country_name` LIKE '%a%a%a%'
ORDER BY `iso_code`;