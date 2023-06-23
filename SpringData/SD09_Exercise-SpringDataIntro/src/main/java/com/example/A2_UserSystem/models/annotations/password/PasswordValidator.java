package com.example.A2_UserSystem.models.annotations.password;

import com.example.A2_UserSystem.models.annotations.AnnotationsUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

import static com.example.A2_UserSystem.constants.Constants.*;

@Component
public class PasswordValidator implements ConstraintValidator<Password, CharSequence> {

    private static final Pattern CONTAINS_DIGIT = Pattern.compile("[0-9]");
    private static final Pattern CONTAINS_LOWER_CASE = Pattern.compile("[a-z]");
    private static final Pattern CONTAINS_UPPER_CASE = Pattern.compile("[A-Z]");
    private static final Pattern CONTAINS_SPECIAL_SYMBOL = Pattern.compile("[!@#$%^&*()_+<>?]");

    private int minLength;
    private int maxLength;
    private boolean hasDigit;
    private boolean hasLower;
    private boolean hasUpper;
    private boolean hasSpecialSymbol;

    @Override
    public void initialize(Password password) {
        this.minLength = password.minLength();
        this.maxLength = password.maxLength();
        this.hasDigit = password.containsDigit();
        this.hasLower = password.containsLowercase();
        this.hasUpper = password.containsUppercase();
        this.hasSpecialSymbol = password.containsSpecialSymbol();
    }

    @Override
    public boolean isValid(final CharSequence value, final ConstraintValidatorContext context) {

      if (value == null) {
          return false;
      }

      if (value.length() < this.minLength) {
          AnnotationsUtil.setErrorMessage(context, PASSWORD_TOO_SHOR);
          return false;
      }

      if (value.length() > this.maxLength) {
          AnnotationsUtil.setErrorMessage(context, PASSWORD_TOO_LONG);
          return false;
      }

      final String password = value.toString();

      if (!CONTAINS_DIGIT.matcher(password).find() && this.hasDigit) {
          AnnotationsUtil.setErrorMessage(context, PASSWORD_MUST_CONTAIN_DIGIT);
          return false;
      }

      if (!CONTAINS_LOWER_CASE.matcher(password).find() && this.hasLower) {
          AnnotationsUtil.setErrorMessage(context, PASSWORD_MUST_CONTAIN_LOWER_CASE);
          return false;
      }

      if (!CONTAINS_UPPER_CASE.matcher(password).find() && this.hasUpper) {
          AnnotationsUtil.setErrorMessage(context, PASSWORD_MUST_CONTAIN_UPPER_CASE);
          return false;
      }

      if (!CONTAINS_SPECIAL_SYMBOL.matcher(password).find() && this.hasSpecialSymbol) {
          AnnotationsUtil.setErrorMessage(context, PASSWORD_MUST_CONTAIN_SPECIAL_SYMBOL);
          return false;
      }

        return true;
    }
}
