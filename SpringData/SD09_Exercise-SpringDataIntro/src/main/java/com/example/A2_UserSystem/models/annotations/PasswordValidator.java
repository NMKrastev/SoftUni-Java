package com.example.A2_UserSystem.models.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    @Override
    public void initialize(Password constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        Method method;

        try {
            method = Password.class.getDeclaredMethod("message");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        Password annotation = method.getAnnotation(Password.class);

        if (password.length() < annotation.min() || password.length() > annotation.max()) {
            return false;
        }

        if (annotation.containsDigit()) {

            final Pattern pattern = Pattern.compile("[0-9]");
            final Matcher matcher = pattern.matcher(password);

            if (!matcher.find()) {
                return false;
            }
        }

        if (annotation.containsLowercase()) {

            final Pattern pattern = Pattern.compile("[a-z]");
            final Matcher matcher = pattern.matcher(password);

            if (!matcher.find()) {
                return false;
            }
        }

        if (annotation.containsUppercase()) {

            final Pattern pattern = Pattern.compile("[A-Z]");
            final Matcher matcher = pattern.matcher(password);

            if (!matcher.find()) {
                return false;
            }
        }

        if (annotation.containsSpecialSymbol()) {

            final Pattern pattern = Pattern.compile("[!@#$%^&*()_+<>?]");
            final Matcher matcher = pattern.matcher(password);

            if (!matcher.find()) {
                return false;
            }
        }

        return true;
    }
}
