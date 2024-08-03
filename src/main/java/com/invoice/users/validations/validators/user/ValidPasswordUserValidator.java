package com.invoice.users.validations.validators.user;

import com.invoice.users.validations.anotations.user.ValidPasswordUser;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidPasswordUserValidator implements ConstraintValidator<ValidPasswordUser, String> {
    @Override
    public void initialize(ValidPasswordUser constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false; // Password cannot be null
        }

        if (value.isEmpty()) {
            return false; // Password cannot be empty
        }

        if (value.length() < 8 || value.length() > 20) {
            return false; // Password length must be between 8 and 20 characters
        }

        if (!value.matches(".*[A-Z].*")) {
            return false; // Password must contain at least one uppercase letter
        }

        if (!value.matches(".*[a-z].*")) {
            return false; // Password must contain at least one lowercase letter
        }

        if (!value.matches(".*\\d.*")) {
            return false; // Password must contain at least one digit
        }

        if (!value.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            return false; // Password must contain at least one special character
        }

        return true;
    }
}
