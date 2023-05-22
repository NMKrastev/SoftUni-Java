SELECT COUNT(*) AS count
FROM travel_cards AS jc
JOIN journeys j on j.`id` = jc.`journey_id`
WHERE `purpose` = 'Technical';