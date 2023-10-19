package bg.softuni.temp.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UsernameRegistrationExistValidator.class)
public @interface UsernameRegistrationExist {

    String message() default "Username already exist!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
