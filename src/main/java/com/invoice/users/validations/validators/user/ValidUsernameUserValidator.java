package com.invoice.users.validations.validators.user;

import com.invoice.users.validations.anotations.user.ValidUsernameUser;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUsernameUserValidator implements ConstraintValidator<ValidUsernameUser, String> {

    @Override
    public void initialize(ValidUsernameUser constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null){
            return false;
        }

        if(value.isEmpty()){
            return false;
        }

        if(value.length() > 20){
            return false;
        }

        if(value.length() < 5){
            return false;
        }
        return true;
    }
}
