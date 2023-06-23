package com.example.A2_UserSystem.models.annotations.password;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Component
@Constraint(validatedBy = PasswordValidator.class)
@Target({FIELD, METHOD})
@Retention(RUNTIME)
public @interface Password {

    String message() default "Invalid password!";

    int minLength() default 6;

    int maxLength() default 30;

    boolean containsDigit() default true;

    boolean containsLowercase() default true;

    boolean containsUppercase() default true;

    boolean containsSpecialSymbol() default true;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
