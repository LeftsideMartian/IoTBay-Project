package iotbay.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Class used for data validation
public class Validator {
    // validate method to wrap regex matching logic
    private static boolean validate(String pattern, String input) {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);
        return matcher.matches();
    }

    // Check if a string is empty
    public static boolean isEmpty(String string) {
        return string.isEmpty();
    }

    // Check if email matches email regex pattern
    public static boolean validateEmail(String email) {
        // Check if email is not empty AND email is valid
        return !isEmpty(email) && validate(ProjectConstants.VALIDATOR_EMAIL_PATTERN, email);
    }

    // Check if password matches password regex pattern
    public static boolean validatePassword(String password) {
        // Check if password is not empty AND password is valid
        return !isEmpty(password) && validate(ProjectConstants.VALIDATOR_PASSWORD_PATTERN, password);
    }
}
