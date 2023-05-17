#Write a query to retrieve information about SoftUni camp's transportation organization.
#Get information about the drivers (name and id) and their vehicle type.
#Submit your queries using the "MySQL prepare DB and Run Queries" strategy.
SELECT v.`driver_id`,
       v.`vehicle_type`,
       CONCAT_WS(' ', c.first_name, c.last_name) AS `driver_name`
FROM `vehicles` AS `v`
         JOIN `campers` AS `c` ON v.driver_id = c.id;