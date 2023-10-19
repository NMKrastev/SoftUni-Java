package bg.softuni.temp.validation;

import bg.softuni.temp.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailExistValidator implements ConstraintValidator<EmailExist, String> {

    private final UserRepository userRepository;

    public EmailExistValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        return this.userRepository
                .findByEmail(email)
                .isEmpty();
    }
}
