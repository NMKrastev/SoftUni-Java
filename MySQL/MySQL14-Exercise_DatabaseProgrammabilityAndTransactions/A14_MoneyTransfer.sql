#Write stored procedure usp_transfer_money(from_account_id, to_account_id, amount) that transfers money from one account to another.
#Consider cases when one of the account_ids is not valid, the amount of money is negative number,
#outgoing balance is enough or transferring from/to one and the same account.
#Make sure that the whole procedure passes without errors and if error occurs make no change in the database.
#Make sure to guarantee exact results working with precision up to fourth sign after decimal point.
#Submit your query statement as Run skeleton, run queries & check DB in Judge.
DELIMITER $$

CREATE PROCEDURE usp_transfer_money(`from_account_id` INT, `to_account_id` INT, `amount` DECIMAL(19, 4))

BEGIN

    IF (SELECT `balance`
        FROM `accounts`
        WHERE `id` = `from_account_id`) >= amount
        AND
       `amount` > 0
        AND
       `from_account_id` != `to_account_id` THEN
        START TRANSACTION;

        UPDATE `accounts`
        SET `balance` = `balance` - `amount`
        WHERE `id` = `from_account_id`;

        UPDATE `accounts`
        SET `balance` = `balance` + `amount`
        WHERE `id` = `to_account_id`;

        IF EXISTS(SELECT `id`
                  FROM `accounts`
                  WHERE `id` = `from_account_id`)
            AND
           EXISTS(SELECT `id`
                  FROM `accounts`
                  WHERE `id` = `to_account_id`) THEN
            COMMIT;
        ELSE
            ROLLBACK;
        END IF;
    END IF;
END $$

DELIMITER ;

CALL usp_transfer_money(1, 2, 10);

SELECT `id`,
       `account_holder_id`,
       `balance`
FROM `accounts`
WHERE `id` = 1;