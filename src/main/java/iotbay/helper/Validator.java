package iotbay.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static boolean validate(String pattern, String input) {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);
        return matcher.matches();
    }

    private static boolean isNotEmpty(String string) {
        return !string.isEmpty();
    }

    public static boolean validateEmail(String email) {
        // Email pattern provided from workshop 9 - matches the standard UTS student email
        String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";
        // Check if email is not empty AND email is valid
        return isNotEmpty(email) && validate(emailPattern, email);
    }

    public static boolean validatePassword(String password) {
        // Password must start with a capital, contain a digit and a special char, and be at least 12 characters long
        String passwordPattern = "(^[A-Z])(?=.*\\d)(?=.*\\W).{11,}";
        // Check if password is not empty AND password is valid
        return isNotEmpty(password) && validate(passwordPattern, password);
    }
}
