#Create a single table as follows. Use appropriate data types.
#            teachers
#teacher_id      name    manager_id
#101             John
#102             Maya    106
#103             Silvia  106
#104             Ted     105
#105             Mark    101
#106             Greta   101

#Insert the data from the example above.
#• Add primary and foreign keys.
#• The foreign key should be between manager_id and teacher_id.
#Submit your queries by using " MySQL run queries & check DB" strategy.
CREATE TABLE `teachers`
(
    `teacher_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name`       VARCHAR(50) NOT NULL,
    `manager_id` INT
);

INSERT INTO `teachers` (`teacher_id`, `name`, `manager_id`)
VALUES (101, 'John', NULL),
       (102, 'Maya', 106),
       (103, 'Silvia', 106),
       (104, 'Ted', 105),
       (105, 'Mark', 101),
       (106, 'Greta', 101);

ALTER TABLE `teachers`
    ADD CONSTRAINT `fk_mangerId_teacherId`
        FOREIGN KEY (`manager_id`)
            REFERENCES teachers (`teacher_id`);
