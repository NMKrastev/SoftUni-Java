package com.example.planner_app.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class PastDateValidator implements ConstraintValidator<PastDate, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        final LocalDate date = LocalDate.parse(value);
        final LocalDate today = LocalDate.now();

        return !date.isBefore(today);
    }
}
