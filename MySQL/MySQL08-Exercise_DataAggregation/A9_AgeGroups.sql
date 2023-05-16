#Write down a query that creates 7 different groups based on their age.
#Age groups should be as follows:
#• [0-10]
#• [11-20]
#• [21-30]
#• [31-40]
#• [41-50]
#• [51-60]
#• [61+]
#The query should return:
#• Age groups
#• Count of wizards in it
#Sort result by increasing size of age groups.
SELECT CASE
           WHEN `age` <= 10 THEN '[0-10]'
           WHEN `age` <= 20 THEN '[11-20]'
           WHEN `age` <= 30 THEN '[21-30]'
           WHEN `age` <= 40 THEN '[31-40]'
           WHEN `age` <= 50 THEN '[41-50]'
           WHEN `age` <= 60 THEN '[51-60]'
           ELSE '[61+]'
           END
                AS `age_group`,
       COUNT(*) AS `wizzard_count`
FROM `wizzard_deposits`
Group By `age_group`
ORDER BY `age_group`;