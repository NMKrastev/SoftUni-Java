SELECT c.`name`,
       COUNT(g.`id`)   AS `game_count`,
       ROUND(AVG(g.`budget`), 2) AS `avg_budget`,
       MAX(g.`rating`) AS `max_rating`
FROM `categories` AS c
         JOIN `games_categories` AS gc ON c.`id` = gc.`category_id`
         JOIN `games` AS g ON g.`id` = gc.`game_id`
GROUP BY c.`name`
HAVING `max_rating` >= 9.5
ORDER BY `game_count` DESC,
         c.name;
