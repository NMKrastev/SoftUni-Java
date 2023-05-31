DELIMITER $$

CREATE PROCEDURE udp_update_budget(`min_game_rating` FLOAT)

BEGIN

    UPDATE `games`
    SET `budget`       = `budget` + 100000,
        `release_date` = ADDDATE(`release_date`, INTERVAL 1 YEAR)
    WHERE `id` NOT IN (SELECT DISTINCT `game_id`
                       FROM games_categories)
      AND `rating` > `min_game_rating`
      AND `release_date` IS NOT NULL;

END $$
