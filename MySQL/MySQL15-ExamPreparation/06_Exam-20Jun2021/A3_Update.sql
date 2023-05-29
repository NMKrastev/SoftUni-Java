UPDATE `cars`
SET `condition` = 'C'
WHERE `make` != 'Mercedes-Benz'
    AND `year` <= 2010
    AND `mileage` >= 800000
    OR `mileage` IS NULL;
