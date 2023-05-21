#Create another table – notification_emails(id, recipient, subject, body).
#Add a trigger to logs table to create new email whenever new record is inserted in logs table.
#The following data is required to be filled for each email:
#• recipient – account_id
#• subject – "Balance change for account: {account_id}"
#• body - "On {date (current date)} your balance was changed from {old} to {new}."
#Submit your query statement as Run skeleton, run queries & check DB in Judge.
CREATE TABLE `logs`
(
    `log_id`     INT PRIMARY KEY AUTO_INCREMENT,
    `account_id` INT NOT NULL,
    `old_sum`    DECIMAL(19, 4),
    `new_sum`    DECIMAL(19, 4)
);

CREATE TABLE notification_emails
(
    `id`        INT PRIMARY KEY AUTO_INCREMENT,
    `recipient` INT NOT NULL,
    `subject`   VARCHAR(100),
    `body`      TEXT
);

DELIMITER $$

CREATE TRIGGER `tr_accounts_after_sum_change`

    AFTER UPDATE
    ON `accounts`
    FOR EACH ROW

BEGIN

    INSERT INTO `logs`(`account_id`,
                       `old_sum`,
                       `new_sum`)
    VALUES (old.`id`,
            old.`balance`,
            new.`balance`);
END $$

CREATE TRIGGER tr_logs_after_insert

    AFTER INSERT
    ON `logs`
    FOR EACH ROW

BEGIN

    INSERT INTO `notification_emails` (`recipient`,
                                       `subject`,
                                       `body`)
    VALUES (NEW.`account_id`,
            CONCAT_WS(' ', 'Balance change for account:', NEW.`account_id`),
            CONCAT_WS(' ', 'On', NOW(), 'your balance was changed from', ROUND(NEW.old_sum), 'to', ROUND(NEW.new_sum),
                      '.'));
END $$