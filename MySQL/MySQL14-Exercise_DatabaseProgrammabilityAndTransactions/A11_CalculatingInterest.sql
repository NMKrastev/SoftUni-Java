#Your task is to create a stored procedure usp_calculate_future_value_for_account that accepts as parameters – id of account and interest rate.
#The procedure uses the function from the previous problem to give an interest to a person's account for 5 years,
#along with information about his/her account id, first name, last name and current balance as it is shown in the example below.
#It should take the account_id and the interest_rate as parameters. Interest rate should have precision up to 0.0001,
#same as the calculated balance after 5 years. Be extremely careful to achieve the desired precision!
DELIMITER $$

CREATE FUNCTION ufn_calculate_future_value(`sum` DECIMAL(19, 4), `yearly_interest_rate` DECIMAL(19, 4), `year` INT)

    RETURNS DECIMAL(19, 4)
    NOT DETERMINISTIC
    READS SQL DATA

BEGIN

    DECLARE `future_value` DECIMAL(19, 4);

    SET `future_value` := `sum` * POW((1 + `yearly_interest_rate`), `year`);

    RETURN `future_value`;

    #RETURN `sum` * POW((1 + `yearly_interest_rate`), `year`);
END $$

CREATE PROCEDURE usp_calculate_future_value_for_account(`person_id` INT, `interest_rate` DECIMAL(19, 4))

BEGIN

    SELECT a.`id` AS `account_id`,
           ah.`first_name`,
           ah.`last_name`,
           a.`balance` AS `current_balance`,
           (SELECT ufn_calculate_future_value(a.`balance`, `interest_rate`, 5))
               AS `balance_in_5_years`
    FROM `account_holders` AS ah
             JOIN accounts AS a ON a.`account_holder_id` = ah.`id`
    WHERE a.`id` = `person_id`;
END $$

DELIMITER ;

CALL usp_calculate_future_value_for_account(1, 0.1);
