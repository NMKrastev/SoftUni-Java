SELECT p.`id`,
       p.`date`     AS `date_and_time`,
       p.`description`,
       COUNT(p.`id`) AS `commentsCount`
FROM comments AS c
         JOIN photos AS p ON p.id = c.photo_id
GROUP BY p.`id`
ORDER BY `commentsCount` DESC, p.`id`
LIMIT 5;