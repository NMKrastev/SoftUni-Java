DELETE
FROM colonists AS c
WHERE c.`id` NOT IN (SELECT tc.`colonist_id` FROM `travel_cards` AS tc);
