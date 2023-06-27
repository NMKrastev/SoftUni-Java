package com.example.A2_UserSystem.entities.annotations.email;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.example.A2_UserSystem.constants.Constants.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Component
@Constraint(validatedBy = EmailValidator.class)
@Target({FIELD, METHOD})
@Retention(RUNTIME)
public @interface Email {

    String message() default INVALID_EMAIL;

    int minUsernameLength() default 1;

    int maxUsernameLength() default 50;

    int maxHostNameLength() default 50;

    String regex() default EMAIL_REGEX;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
