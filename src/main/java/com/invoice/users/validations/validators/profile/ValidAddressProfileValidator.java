package com.invoice.users.validations.validators.profile;

import com.invoice.users.validations.anotations.profile.ValidAddressProfile;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidAddressProfileValidator implements ConstraintValidator<ValidAddressProfile, String> {
    @Override
    public void initialize(ValidAddressProfile constraintAnnotation) {
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

        if(value.length() > 200){
            return false;
        }

        if(value.length() < 10){
            return false;
        }
        return true;
    }
}
