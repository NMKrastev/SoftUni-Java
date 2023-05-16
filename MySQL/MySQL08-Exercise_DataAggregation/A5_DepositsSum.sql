#Select all deposit groups and its total deposit sum. Sort result by total_sum in increasing order.
SELECT `deposit_group`, ROUND(SUM(`deposit_amount`), 2) AS `total_sum`
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `total_sum`;