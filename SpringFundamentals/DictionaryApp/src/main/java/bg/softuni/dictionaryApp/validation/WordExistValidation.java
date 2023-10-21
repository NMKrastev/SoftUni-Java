package bg.softuni.dictionaryApp.validation;

import bg.softuni.dictionaryApp.repository.WordRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class WordExistValidation implements ConstraintValidator<WordExist, String> {

    private final WordRepository wordRepository;

    public WordExistValidation(WordRepository wordRepository) {

        this.wordRepository = wordRepository;
    }

    @Override
    public boolean isValid(String word, ConstraintValidatorContext context) {

        return this.wordRepository
                .findByTerm(word)
                .isEmpty();
    }
}
