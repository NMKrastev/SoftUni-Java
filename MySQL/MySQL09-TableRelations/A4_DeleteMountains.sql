#Drop tables from the task 1.
#Write a query to create a one-to-many relationship between a table,
#holding information about mountains (id, name) and other - about peaks (id, name, mountain_id),
#so that when a mountain gets removed from the database, all his peaks are deleted too.
#Submit your queries using the "MySQL run queries & check DB" strategy.
CREATE TABLE `mountains`
(
    `id`   INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE `peaks`
(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `mountain_id` INT NOT NULL,
    CONSTRAINT `fk_peaks_mountains`
        FOREIGN KEY (`mountain_id`)
            REFERENCES `mountains`(`id`)
    ON DELETE CASCADE
);