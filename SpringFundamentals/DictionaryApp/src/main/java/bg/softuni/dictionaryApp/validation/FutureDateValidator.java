package bg.softuni.dictionaryApp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class FutureDateValidator implements ConstraintValidator<FutureDate, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value.isBlank()) {
            return false;
        }

        final LocalDate date = LocalDate.parse(value);
        final LocalDate today = LocalDate.now();

        return !date.isAfter(today);
    }
}
