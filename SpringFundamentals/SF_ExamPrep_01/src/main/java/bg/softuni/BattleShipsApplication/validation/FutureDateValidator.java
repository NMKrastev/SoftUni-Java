package bg.softuni.BattleShipsApplication.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class FutureDateValidator implements ConstraintValidator<FutureDate, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        final LocalDate date = LocalDate.parse(value);
        final LocalDate today = LocalDate.now();

        return !date.isAfter(today);
    }
}
