DROP VIEW IF EXISTS car_brand_creation_datetime;

CREATE VIEW car_brand_creation_datetime AS
SELECT CURRENT_TIMESTAMP - INTERVAL FLOOR(RAND() * 20000 * 24 * 60 * 60) SECOND;

INSERT INTO brands (name, created)
VALUES ('Acura', (SELECT * FROM car_brand_creation_datetime)),
       ('Alfa-Romeo', (SELECT * FROM car_brand_creation_datetime)),
       ('Aston Martin', (SELECT * FROM car_brand_creation_datetime)),
       ('Audi', (SELECT * FROM car_brand_creation_datetime)),
       ('BMW', (SELECT * FROM car_brand_creation_datetime)),
       ('Bentley', (SELECT * FROM car_brand_creation_datetime)),
       ('Buick', (SELECT * FROM car_brand_creation_datetime)),
       ('Cadillac', (SELECT * FROM car_brand_creation_datetime)),
       ('Chevrolet', (SELECT * FROM car_brand_creation_datetime)),
       ('Chrysler', (SELECT * FROM car_brand_creation_datetime)),
       ('Daewoo', (SELECT * FROM car_brand_creation_datetime)),
       ('Daihatsu', (SELECT * FROM car_brand_creation_datetime)),
       ('Dodge', (SELECT * FROM car_brand_creation_datetime)),
       ('Eagle', (SELECT * FROM car_brand_creation_datetime)),
       ('Ferrari', (SELECT * FROM car_brand_creation_datetime)),
       ('Fiat', (SELECT * FROM car_brand_creation_datetime)),
       ('Fisker', (SELECT * FROM car_brand_creation_datetime)),
       ('Ford', (SELECT * FROM car_brand_creation_datetime)),
       ('Freightliner', (SELECT * FROM car_brand_creation_datetime)),
       ('GMC', (SELECT * FROM car_brand_creation_datetime)),
       ('Genesis', (SELECT * FROM car_brand_creation_datetime)),
       ('Geo', (SELECT * FROM car_brand_creation_datetime)),
       ('Honda', (SELECT * FROM car_brand_creation_datetime)),
       ('Hummer', (SELECT * FROM car_brand_creation_datetime)),
       ('Hyundai', (SELECT * FROM car_brand_creation_datetime)),
       ('Infinity', (SELECT * FROM car_brand_creation_datetime)),
       ('Isuzu', (SELECT * FROM car_brand_creation_datetime)),
       ('Jaguar', (SELECT * FROM car_brand_creation_datetime)),
       ('Jeep', (SELECT * FROM car_brand_creation_datetime)),
       ('Kia', (SELECT * FROM car_brand_creation_datetime)),
       ('Lamborghini', (SELECT * FROM car_brand_creation_datetime)),
       ('Land Rover', (SELECT * FROM car_brand_creation_datetime)),
       ('Lexus', (SELECT * FROM car_brand_creation_datetime)),
       ('Lincoln', (SELECT * FROM car_brand_creation_datetime)),
       ('Lotus', (SELECT * FROM car_brand_creation_datetime)),
       ('Mazda', (SELECT * FROM car_brand_creation_datetime)),
       ('Maserati', (SELECT * FROM car_brand_creation_datetime)),
       ('Maybach', (SELECT * FROM car_brand_creation_datetime)),
       ('McLaren', (SELECT * FROM car_brand_creation_datetime)),
       ('Mercedes-Benz', (SELECT * FROM car_brand_creation_datetime)),
       ('Mercury', (SELECT * FROM car_brand_creation_datetime)),
       ('Mini', (SELECT * FROM car_brand_creation_datetime)),
       ('Mitsubishi', (SELECT * FROM car_brand_creation_datetime)),
       ('Nissan', (SELECT * FROM car_brand_creation_datetime)),
       ('Oldsmobile', (SELECT * FROM car_brand_creation_datetime)),
       ('Panoz', (SELECT * FROM car_brand_creation_datetime)),
       ('Plymouth', (SELECT * FROM car_brand_creation_datetime)),
       ('Polestar', (SELECT * FROM car_brand_creation_datetime)),
       ('Pontiac', (SELECT * FROM car_brand_creation_datetime)),
       ('Porsche', (SELECT * FROM car_brand_creation_datetime)),
       ('Ram', (SELECT * FROM car_brand_creation_datetime)),
       ('Rivian', (SELECT * FROM car_brand_creation_datetime)),
       ('Rolls_Royce', (SELECT * FROM car_brand_creation_datetime)),
       ('Saab', (SELECT * FROM car_brand_creation_datetime)),
       ('Saturn', (SELECT * FROM car_brand_creation_datetime)),
       ('Smart', (SELECT * FROM car_brand_creation_datetime)),
       ('Subaru', (SELECT * FROM car_brand_creation_datetime)),
       ('Suzuki', (SELECT * FROM car_brand_creation_datetime)),
       ('Tesla', (SELECT * FROM car_brand_creation_datetime)),
       ('Toyota', (SELECT * FROM car_brand_creation_datetime)),
       ('Volkswagen', (SELECT * FROM car_brand_creation_datetime)),
       ('Volvo', (SELECT * FROM car_brand_creation_datetime));

/*DROP PROCEDURE IF EXISTS car_model_creation_datetime;

CREATE FUNCTION car_model_creation_datetime(brand_id INT)
    RETURNS DATETIME
    NOT DETERMINISTIC
    READS SQL DATA
BEGIN
    DECLARE model_creation DATETIME;
    SET model_creation := FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW()));
    RETURN model_creation;
END;*/

INSERT INTO models (name, brand_id, created, category, star_year, end_year)
VALUES ('Acura MODEL 1', 1, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2017, 2022),
       ('Acura MODEL 2', 1, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2021, NULL),
       ('Alfa-Romeo MODEL 1', 2, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2023, NULL),
       ('Aston Martin MODEL 1', 3, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2004, 2010),
       ('Audi MODEL 1', 4, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2011, 2021),
       ('Audi MODEL 2', 4, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2002, NULL),
       ('Audi MODEL 3', 4, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2003, 2023),
       ('Audi MODEL 4', 4, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'BUS', 2012, NULL),
       ('BMW MODEL 1', 5, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2020, NULL),
       ('BMW MODEL 2', 5, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2023, NULL),
       ('BMW MODEL 3', 5, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2021, NULL),
       ('BMW MODEL 4', 5, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'MOTORCYCLE', 2020, NULL),
       ('BMW MODEL 5', 5, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'TRUCK', 2022, 2023),
       ('Bentley MODEL 1', 6, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2023, NULL),
       ('Buick MODEL 1', 7, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 1988, 1998),
       ('Cadillac MODEL 1', 8, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2012, 2017),
       ('Chevrolet MODEL 1', 9, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 1981, 1995),
       ('Chevrolet MODEL 2', 9, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2013, NULL),
       ('Chrysler MODEL 1', 10, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2004, 2010),
       ('Daewoo MODEL 1', 11, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'TRUCK', 2010, 2020),
       ('Daihatsu MODEL 1', 12, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'TRUCK', 2010, 2018),
       ('Dodge MODEL 1', 13, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2019, NULL),
       ('Dodge MODEL 2', 13, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 1986, 1992),
       ('Eagle MODEL 1', 14, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2003, 2006),
       ('Ferrari MODEL 1', 15, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())),'CAR', 2014, 2020),
       ('Ferrari MODEL 2', 15, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2020, NULL),
       ('Ferrari MODEL 3', 15, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2013, 2019),
       ('Fiat MODEL 1', 16, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2020, NULL),
       ('Fiat MODEL 2', 16, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2020, 2022),
       ('Fisker MODEL 1', 17, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'TRUCK', 1990, 1997),
       ('Ford MODEL 1', 18, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2019, NULL),
       ('Ford MODEL 2', 18, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2010, 2020),
       ('Ford MODEL 3', 18, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'TRUCK', 2020, NULL),
       ('Freightliner MODEL 1', 19, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'TRUCK', 1998, 2005),
       ('GMC MODEL 1', 20, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2023, NULL),
       ('GMC MODEL 2', 20, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'BUS', 2023, NULL),
       ('Genesis MODEL 1', 21, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2022, NULL),
       ('Geo MODEL 1', 22, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2018, 2021),
       ('Honda MODEL 1', 23, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'MOTORCYCLE', 2021, NULL),
       ('Honda MODEL 2', 23, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'MOTORCYCLE', 2017, 2022),
       ('Honda MODEL 3', 23, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2016, 2020),
       ('Honda MODEL 4', 23, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2021, NULL),
       ('Hummer MODEL 1', 24, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2005, 2010),
       ('Hummer MODEL 1', 24, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'TRUCK', 1993, 2000),
       ('Hyundai MODEL 1', 25, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2005, 2010),
       ('Hyundai MODEL 2', 25, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 1992, 2005),
       ('Infinity MODEL 1', 26, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2022, NULL),
       ('Infinity MODEL 2', 26, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2017, 2023),
       ('Isuzu MODEL 1', 27, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())),'TRUCK', 2012, 2018),
       ('Jaguar MODEL 1', 28, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 1994, 2001),
       ('Jaguar MODEL 2', 28, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 1977, 1984),
       ('Jeep MODEL 1', 29, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 1992, 2002),
       ('Jeep MODEL 2', 29, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2007, 2012),
       ('Kia MODEL 1', 30, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 1999, 2005),
       ('Kia MODEL 2', 30, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 1989, 1992),
       ('Kia MODEL 3', 30, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 1999, 2009),
       ('Lamborghini MODEL 1', 31, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2013, 2020),
       ('Lamborghini MODEL 2', 31, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2007, 2012),
       ('Lamborghini MODEL 3', 31, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2010, NULL),
       ('Land Rover MODEL 1', 32, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 1990, 1996),
       ('Lexus MODEL 1', 33, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2020, NULL),
       ('Lexus MODEL 2', 33, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())),'CAR', 2020, 2023),
       ('Lincoln MODEL 1', 34, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())),'CAR', 2016, 2021),
       ('Lotus MODEL 1', 35, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2021, NULL),
       ('Mazda MODEL 1', 36, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2020, NULL),
       ('Mazda MODEL 2', 36, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2019, 2023),
       ('Mazda MODEL 3', 36, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2020, NULL),
       ('Maserati MODEL 1', 37, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2021, NULL),
       ('Maserati MODEL 2', 37, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2013, 2019),
       ('Maybach MODEL 1', 38, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2013, 2018),
       ('Maybach MODEL 2', 38, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2011, 2020),
       ('McLaren MODEL 1', 39, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2009, 2015),
       ('McLaren MODEL 2', 39, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 1994, 1999),
       ('Mercedes-Benz MODEL 1', 40, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'TRUCK', 2016, 2022),
       ('Mercedes-Benz MODEL 2', 40, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2010, 2020),
       ('Mercedes-Benz MODEL 3', 40, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2004, 2011),
       ('Mercedes-Benz MODEL 4', 40, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'BUS', 2014, 2020),
       ('Mercedes-Benz MODEL 5', 40, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2013, NULL),
       ('Mercury MODEL 1', 41, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 1985, 1990),
       ('Mini MODEL 1', 42, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2012, 2017),
       ('Mini MODEL 2', 42, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2015, 2020),
       ('Mitsubishi MODEL 1', 43, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2021, NULL),
       ('Mitsubishi MODEL 2', 43, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2019, 2023),
       ('Mitsubishi MODEL 3', 43, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'BUS', 2021, NULL),
       ('Nissan MODEL 1', 44, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2020, NULL),
       ('Nissan MODEL 2', 44, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2018, 2023),
       ('Nissan MODEL 3', 44, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2019, NULL),
       ('Nissan MODEL 4', 44, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2023, NULL),
       ('Oldsmobile MODEL 1', 45, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2022, NULL),
       ('Panoz MODEL 1', 46, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2006, 2011),
       ('Plymouth MODEL 1', 47, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2019, 2022),
       ('Polestar MODEL 1', 48, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2017, 2023),
       ('Pontiac MODEL 1', 49, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2017, 2020),
       ('Pontiac MODEL 2', 49, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2014, 2020),
       ('Porsche MODEL 1', 50, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2022, NULL),
       ('Porsche MODEL 2', 50, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2023, NULL),
       ('Porsche MODEL 3', 50, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2022, NULL),
       ('Porsche MODEL 4', 50, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2021, 2023),
       ('Ram MODEL 1', 51, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'TRUCK', 2022, NULL),
       ('Rivian MODEL 1', 52, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2005, 2010),
       ('Rolls_Royce MODEL 1', 53, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2018, 2022),
       ('Rolls_Royce MODEL 2', 53, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2021, NULL),
       ('Rolls_Royce MODEL 3', 53, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2018, NULL),
       ('Saab MODEL 1', 54, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2012, 2018),
       ('Saab MODEL 2', 54, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2015, 2021),
       ('Saturn MODEL 1', 55, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2013, 2020),
       ('Smart MODEL 1', 56, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2006, 2012),
       ('Smart MODEL 2', 56, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2019, NULL),
       ('Subaru MODEL 1', 57, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 1985, 1992),
       ('Subaru MODEL 2', 57, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 1988, 1998),
       ('Subaru MODEL 3', 57, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2009, 2015),
       ('Suzuki MODEL 1', 58, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2014, 2020),
       ('Suzuki MODEL 2', 58, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2015, 2022),
       ('Tesla MODEL 1', 59, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2022, NULL),
       ('Tesla MODEL 2', 59, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2022, NULL),
       ('Tesla MODEL 3', 59, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2019, 2023),
       ('Tesla MODEL 4', 59, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2022, NULL),
       ('Toyota MODEL 1', 60, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2021, NULL),
       ('Toyota MODEL 2', 60, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'TRUCK', 2023, NULL),
       ('Toyota MODEL 3', 60, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'BUS', 2013, 2019),
       ('Toyota MODEL 4', 60, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2018, 2023),
       ('Toyota MODEL 5', 60, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2012, NULL),
       ('Toyota MODEL 6', 60, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2012, 2021),
       ('Volkswagen MODEL 1', 61, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2021, NULL),
       ('Volkswagen MODEL 2', 61, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2018, 2022),
       ('Volkswagen MODEL 3', 61, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'BUS', 2023, NULL),
       ('Volkswagen MODEL 4', 61, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'TRUCK', 2018, 2023),
       ('Volkswagen MODEL 5', 61, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2018, NULL),
       ('Volvo MODEL 1', 62, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 1990, NULL),
       ('Volvo MODEL 2', 62, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'TRUCK', 2000, 2010),
       ('Volvo MODEL 3', 62, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2005, 2011),
       ('Volvo MODEL 4', 62, FROM_UNIXTIME(RAND() * (UNIX_TIMESTAMP((SELECT TIMESTAMP(brands.created) FROM brands WHERE id = brand_id)) - UNIX_TIMESTAMP(NOW())) + UNIX_TIMESTAMP(NOW())), 'CAR', 2003, 2023);;