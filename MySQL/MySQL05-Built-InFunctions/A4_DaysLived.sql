#Write a SQL query to calculate the days that an author lived. Your query should return:
#•	Full Name – the full name of the author.
#•	Days Lived – days that he/she lived. NULL values mean that the author is still alive.
#Submit your query statements as Prepare DB & run queries.
SELECT CONCAT_WS(' ', `first_name`, `last_name`) AS `Full Name`,
       TIMESTAMPDIFF(DAY, `born`, `died`) AS 'Days Lived'
FROM `authors`;
