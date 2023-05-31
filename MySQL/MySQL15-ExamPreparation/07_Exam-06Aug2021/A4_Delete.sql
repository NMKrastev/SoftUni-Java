DELETE
FROM `games` AS g
WHERE g.`id` NOT IN (SELECT DISTINCT gc.`game_id`
                     FROM `games_categories` AS gc)
  AND `release_date` IS NULL;