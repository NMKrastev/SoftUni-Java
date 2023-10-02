package bg.softuni.BattleShipsApplication.validation;

import bg.softuni.BattleShipsApplication.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsernameLoginExistValidator implements ConstraintValidator<UsernameLoginExist, String> {

    private final UserRepository userRepository;

    public UsernameLoginExistValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {

        return this.userRepository
                .findByUsername(username)
                .isPresent();
    }
}
