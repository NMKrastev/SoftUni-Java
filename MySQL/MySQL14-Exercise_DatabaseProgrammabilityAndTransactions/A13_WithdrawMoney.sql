#Add stored procedures usp_withdraw_money(account_id, money_amount) that operate in transactions.
#Make sure to guarantee withdraw is done only when balance is enough and money_amount is valid positive number.
#Work with precision up to fourth sign after decimal point.
#The procedure should produce exact results working with the specified precision.
#Submit your query statement as Run skeleton, run queries & check DB in Judge.
DELIMITER $$

CREATE PROCEDURE usp_withdraw_money(`person_id` INT, `money_amount` DECIMAL(19, 4))

BEGIN

    IF (SELECT `balance`
        FROM accounts
        WHERE `id` = `person_id`) - money_amount >= 0
        AND money_amount > 0 THEN
        START TRANSACTION;

        UPDATE `accounts`
        SET `balance` = `balance` - `money_amount`
        WHERE `id` = `person_id`;

        IF EXISTS(SELECT `id`
                  FROM accounts
                  WHERE `id` = `person_id`) THEN
            COMMIT;
        ELSE
            ROLLBACK;
        END IF;
    END IF;
END $$

DELIMITER ;

CALL usp_withdraw_money(1, 10);

SELECT * FROM accounts
WHERE `id` = 1;