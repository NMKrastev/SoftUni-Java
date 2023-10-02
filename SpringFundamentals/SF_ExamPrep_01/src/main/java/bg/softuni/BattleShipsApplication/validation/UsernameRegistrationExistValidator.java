package bg.softuni.BattleShipsApplication.validation;

import bg.softuni.BattleShipsApplication.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsernameRegistrationExistValidator implements ConstraintValidator<UsernameRegistrationExist, String> {

    private final UserRepository userRepository;

    public UsernameRegistrationExistValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {

        return this.userRepository
                .findByUsername(username)
                .isEmpty();
    }
}
