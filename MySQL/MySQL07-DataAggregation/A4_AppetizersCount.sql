#Write a query to retrieve the count of all appetizers (category id = 2) with price higher than 8.
#Submit your queries with the MySQL prepare DB & run queries strategy.
SELECT COUNT(`category_id`) AS `Apetizers Count`
FROM `products`
WHERE `category_id` = 2 AND price > 8;