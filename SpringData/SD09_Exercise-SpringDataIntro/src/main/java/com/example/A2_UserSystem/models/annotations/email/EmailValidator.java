package com.example.A2_UserSystem.models.annotations.email;

import com.example.A2_UserSystem.models.annotations.AnnotationsUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

import static com.example.A2_UserSystem.constants.Constants.*;

@Component
public class EmailValidator implements ConstraintValidator<Email, CharSequence> {

    private int minUsernameLength;
    private int maxUsernameLength;
    private int maxHostNameLength;
    private Pattern pattern;


    @Override
    public void initialize(final Email email) {
        this.minUsernameLength = email.minUsernameLength();
        this.maxUsernameLength = email.maxUsernameLength();
        this.maxHostNameLength = email.maxHostNameLength();
        this.pattern = Pattern.compile(email.regex());
    }

    @Override
    public boolean isValid(final CharSequence value, final ConstraintValidatorContext context) {

        if (value == null) {
            return false;
        }

        String email = value.toString();
        int usernameLength = email.indexOf("@");
        int hostNameLength = email.length() - email.lastIndexOf("@") - 1;

        if (usernameLength < this.minUsernameLength) {
            AnnotationsUtil.setErrorMessage(context, EMAIL_NAME_LENGTH_TOO_SHORT);
            return false;
        }

        if (usernameLength > this.maxUsernameLength) {
            AnnotationsUtil.setErrorMessage(context, EMAIL_NAME_LENGTH_TOO_LONG);
            return false;
        }

        if (hostNameLength > this.maxHostNameLength) {
            AnnotationsUtil.setErrorMessage(context, EMAIL_HOST_LENGTH_TOO_LONG);
            return false;
        }

        return this.pattern.matcher(email).matches();
    }
}
