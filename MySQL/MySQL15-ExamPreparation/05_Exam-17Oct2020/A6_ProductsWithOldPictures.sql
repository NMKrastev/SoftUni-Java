SELECT pr.`name`,
       pr.`price`,
       pr.`best_before`,
       CONCAT(SUBSTRING(pr.`description`, 1, 10), '...') AS `short_description`,
       p.`url`
FROM `products` AS pr
         JOIN `pictures` AS p ON p.`id` = pr.`picture_id`
WHERE CHAR_LENGTH(`description`) > 100
  AND YEAR(p.`added_on`) < 2019
  AND pr.`price` > 20
ORDER BY pr.`price` DESC;