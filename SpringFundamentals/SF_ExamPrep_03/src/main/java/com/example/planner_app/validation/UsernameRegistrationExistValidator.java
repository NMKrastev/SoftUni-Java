package com.example.planner_app.validation;

import com.example.planner_app.repository.UserRepository;
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
