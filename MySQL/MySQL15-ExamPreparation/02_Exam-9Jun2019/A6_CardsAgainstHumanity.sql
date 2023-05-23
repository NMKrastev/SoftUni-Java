SELECT ca.`id`,
       CONCAT_WS(' : ', ca.`card_number`, cl.`full_name`) AS `card_token`
FROM `cards` AS ca
JOIN `bank_accounts` AS ba ON ba.`id` = ca.`bank_account_id`
JOIN `clients` AS cl ON cl.`id` = ba.`client_id`
ORDER BY ca.`id` DESC;