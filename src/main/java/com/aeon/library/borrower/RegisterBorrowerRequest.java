package com.aeon.library.borrower;

import com.aeon.library.LibraryException;
import lombok.Data;

import java.util.regex.Pattern;

@Data
public class RegisterBorrowerRequest {
    String name;
    String email;

    private static String VALID_EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$";
    private static final Pattern VALID_EMAIL_PATTERN = Pattern.compile(VALID_EMAIL_REGEX);

    public void isValidBorrower() {
        if (!isValidName()) {
            throw new LibraryException("Invalid name!", new RuntimeException());
        }
        if (!isValidEmail()) {
            throw new LibraryException("Invalid email!", new RuntimeException());
        }
    }

    private boolean isValidName() {
        return !name.isBlank() && name.length() >= 2 && name.length() <= 100;
    }

    private boolean isValidEmail() {
        return !email.isBlank() && VALID_EMAIL_PATTERN.matcher(email).matches();
    }
}
