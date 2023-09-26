package bg.softuni.mobilelele.model.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UserEmailExistValidator.class)
public @interface UserEmailExist {

    String message() default "Invalid email or password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
