UPDATE `employees` AS e
SET e.`salary` = e.`salary` + 1000
WHERE e.`id` IN (SELECT DISTINCT `leader_id`
                 FROM `teams`)
  AND `age` < 40
  AND e.`salary` < 5000;