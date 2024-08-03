package com.invoice.users.validations.validators.profile;

import com.invoice.users.validations.anotations.profile.ValidNameProfile;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNameProfileValidator implements ConstraintValidator<ValidNameProfile, String> {
    @Override
    public void initialize(ValidNameProfile constraintAnnotation) {
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

        if(value.length() > 30){
            return false;
        }

        if(value.length() < 2){
            return false;
        }
        return true;
    }
}
