package com.example.planner_app.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = EmailExistValidator.class)
public @interface EmailExist {

    String message() default "Email is already in use!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
