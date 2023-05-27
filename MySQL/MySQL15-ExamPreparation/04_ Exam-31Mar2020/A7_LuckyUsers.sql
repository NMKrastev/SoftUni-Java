SELECT CONCAT_WS(' ', u.`id`, u.`username`),
       u.`email`
FROM `users` AS u
JOIN `users_photos` AS up ON up.`user_id` = u.`id`
WHERE `user_id` = `photo_id`
ORDER BY u.`id`;