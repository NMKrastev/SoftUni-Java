#Write a query that selects:
#• continent_code
#• currency_code
#• currency_usage
#Find all continents and their most used currency.
#Filter any currency that is used in only one country.
#Sort the result by continent_code and currency_code.
SELECT c1.`continent_code`,
       c1.`currency_code`,
       COUNT(c1.`country_code`) AS `currency_usage`
FROM `countries` AS c1
GROUP BY currency_code, continent_code
HAVING COUNT(c1.`country_code`) > 1
   AND `currency_usage` =
       (SELECT COUNT(*) AS cu
        FROM `countries` AS c2
        WHERE c2.`continent_code` = c1.`continent_code`
        GROUP BY c2.`currency_code`
        ORDER BY cu DESC
        LIMIT 1)
ORDER BY c1.`continent_code`, c1.`currency_code`;