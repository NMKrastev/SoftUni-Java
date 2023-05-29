UPDATE addresses
SET `country` = (CASE
                     WHEN `country` REGEXP '^[B]' THEN 'Blocked'
                     WHEN `country` REGEXP '^[T]' THEN 'Test'
                     WHEN `country` REGEXP '^[P]' THEN 'In Progress'
                     ELSE `country`
    END);