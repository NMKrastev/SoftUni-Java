#Find the 30 biggest countries by population from Europe. Display the country name and population.
#Sort the results by population (from biggest to smallest), then by country alphabetically.
#Submit your query statements as Prepare DB & run queries.
SELECT `country_name`, `population`
FROM `countries`
WHERE `continent_code` = 'EU'
ORDER BY `population` DESC, `country_name`
LIMIT 30;